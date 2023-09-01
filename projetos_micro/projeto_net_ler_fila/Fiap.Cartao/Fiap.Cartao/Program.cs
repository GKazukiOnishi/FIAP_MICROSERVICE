using System.Net.Http.Json;
using System.Text;
using System.Text.Json;
using RabbitMQ.Client;
using RabbitMQ.Client.Events;

namespace Fiap.Cartao
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var factory = new ConnectionFactory { HostName = "localhost" };
            using var connection = factory.CreateConnection();
            using var channel = connection.CreateModel();

            channel.QueueDeclare(queue: "hello", //fila chamada hello
                                 durable: false, //para indicar que pode ser reiniciada que vai continuar lá
                                 exclusive: false, //exclusiva de quem estiver criando, outra aplicação não pode ser conectar
                                 autoDelete: false, //ao desligar a aplicação vai excluir a fila também
                                 arguments: null); //argumentos adicionais

            Console.WriteLine(" [*] Aguardando novas mensagens.");

            var consumer = new EventingBasicConsumer(channel);
            consumer.Received += async (model, ea) => //toda hora que o evento acontecer, vai chamar a função, ea -> events argumentos
            {
                var body = ea.Body.ToArray();
                var message = Encoding.UTF8.GetString(body);
                Console.WriteLine($" [x] recebido {message}");

                var cartao = await ValidarCartao1();
                
                if (cartao is null)
                {
                    Console.WriteLine("Erro ao validar cartão");
                    //tag, multiplos, reenfileirar -> indica se volta pro começo da fila, o nack em si mantém na fila já
                    channel.BasicNack(ea.DeliveryTag, false, false);
                } else
                {
                    Console.WriteLine("Cartão validado com sucesso");
                    channel.BasicAck(ea.DeliveryTag, false);
                }
            };
            channel.BasicConsume(queue: "hello", //configurando no canal a fila a ser ouvida
                                 autoAck: false, //se true, retorna o ack, para tirar da fila, está automático aqui com o true. se for false não
                                 consumer: consumer); //código de consumo da fila
            Console.WriteLine(" Pressione [enter] para finalizar.");
            Console.ReadLine(); //código vai parar aqui e vai deixar a fila rodando até digitarem algo
        }

        //Task diz que o método vai rodar de forma assíncrona, pode parar a execução para rodar depois (deixa threads se organizarem melhor)
        static async Task<Cartao> ValidarCartao()
        {
            var httpClient = new HttpClient();

            //await libera a thread para fazer outras coisas, até finalizar, mas vai esperar nesse ponto aqui
            var response = await httpClient.GetFromJsonAsync<Cartao>("https://demo6017126.mockable.io/validar-cartao");
            //depois volta ao normal
            //GetFromJson sabe converter o JSON no objeto da classe

            if (response == null)
            {
                Console.WriteLine("Erro ao validar cartão");
                return null;
            }

            //retorno do serviço
            return response;
        }

        static async Task<Cartao> ValidarCartao1()
        {
            var httpClient = new HttpClient();

            var response = await httpClient.GetAsync("https://demo6017126.mockable.io/validar-cartao");

            if (!response.IsSuccessStatusCode)
            {
                Console.WriteLine($"Erro ao validar. Status code: {response.StatusCode}");
                return null;
            }

            return JsonSerializer.Deserialize<Cartao>(response.Content.ReadAsStream());
        }
    }
    public class Cartao
    {
        public string idPedido { get; set; }
        public string numeroCartao { get; set; }
        public string portador { get; set; }
        public int cvv { get; set; }
        public string vencimento { get; set; }
    }
}

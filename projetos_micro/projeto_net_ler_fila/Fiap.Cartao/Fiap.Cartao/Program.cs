using System.Net.Http.Json;
using System.Text;
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
            consumer.Received += (model, ea) => //toda hora que o evento acontecer, vai chamar a função, ea -> events argumentos
            {
                var body = ea.Body.ToArray();
                var message = Encoding.UTF8.GetString(body);
                Console.WriteLine($" [x] recebido {message}");

                channel.BasicAck(ea.DeliveryTag, false);
            };
            channel.BasicConsume(queue: "hello", //configurando no canal a fila a ser ouvida
                                 autoAck: false, //se true, retorna o ack, para tirar da fila, está automático aqui com o true. se for false não
                                 consumer: consumer); //código de consumo da fila
            Console.WriteLine(" Pressione [enter] para finalizar.");
            Console.ReadLine(); //código vai parar aqui e vai deixar a fila rodando até digitarem algo
        }

        static async Task<Cartao> ValidarCartao()
        {
            var httpClient = new HttpClient();

            var response = await httpClient.GetFromJsonAsync<Cartao>("https://demo6017126.mockable.io/validar-cartao");

            if (response == null)
            {
                Console.WriteLine("Erro ao validar cartão");
                return null;
            }

            return response;
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

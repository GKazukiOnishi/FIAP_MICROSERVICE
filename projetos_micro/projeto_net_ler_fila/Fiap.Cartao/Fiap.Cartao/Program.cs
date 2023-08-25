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
            };
            channel.BasicConsume(queue: "hello", //configurando no canal a fila a ser ouvida
                                 autoAck: true, //retorna o ack, para tirar da fila, está automático aqui
                                 consumer: consumer); //código de consumo da fila
            Console.WriteLine(" Pressione [enter] para finalizar.");
            Console.ReadLine(); //código vai parar aqui e vai deixar a fila rodando até digitarem algo
        }
    }
}
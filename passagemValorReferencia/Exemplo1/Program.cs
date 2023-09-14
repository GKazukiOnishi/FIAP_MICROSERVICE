internal class Program
{
    private static void Main(string[] args)
    {
        Console.WriteLine("Hello, World!");

        int idade = 10;

        Incrementar(idade);
        Console.WriteLine("Após o método " + idade);

        IncrementarReferencia(ref idade);
        Console.WriteLine("Após o método " + idade);

        void Incrementar(int idade)
        {
            idade = idade + 1;
            Console.WriteLine("Incremento no parâmetro por valor: " + idade);
        }

        void IncrementarReferencia(ref int idade)
        {
            idade = idade + 1;
            Console.WriteLine("Incremento no parâmetro por referência: " + idade);
        }
    }
}
using System.Net.Http.Json;

internal static class ProgramHelpers
{

    static async Task<Cartao> ValidarCartao()
    {
        var httpClient = new HttpClient();

        var response = httpClient.GetFromJsonAsync<Cartao>("");

        if (response == null)
        {
            Console.WriteLine("Erro ao validar cartão");
            return null;
        }

        return response;
    }
}
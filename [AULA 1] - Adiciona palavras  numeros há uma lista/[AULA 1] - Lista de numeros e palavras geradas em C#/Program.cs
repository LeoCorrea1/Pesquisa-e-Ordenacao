namespace ordenacao
{

    internal class Util
    {

        public static void popularAleatorioNumeros(List<int> lista, long quantidade, int inicio, int fim)
        {
            Random gerador = new Random();
            for (; quantidade > 0; quantidade--)
            {
                lista.Add(gerador.Next(inicio, fim));
            }
        }

        public static void exibirListaNumeros(List<int> lista)
        {
            foreach (int item in lista)
            {
                Console.WriteLine(item);
            }


        }

        public static void exibirListaPalavras(List<string> lista)
        {

            foreach (string item in lista)
            {
                Console.WriteLine(item);
            }

        }

        public static void popularAleatorioPalavras(List<String> lista, long quantidade, int tamanho)
        {
            String letras = "abcdefghijklmnopqrstuvwxyz ";
            Random gerador = new Random();


            for (; quantidade > 0; quantidade--)
            {
                String palavraGerada = "";
                char letraSorteada;

                for (int i = 0; i < tamanho; i++)
                {
                    letraSorteada = letras[gerador.Next(letras.Length)]; ;
                    palavraGerada = palavraGerada + letraSorteada;
                }
                lista.Add(palavraGerada);
            }
        }
    }
internal class Program
        {
            public static void Main(string[] args)
            {
                List<int> listaNumeros = new List<int>();
            List<int> lista2Numeros = new List<int>();
            List<string> listaPalavras = new List<string>();

            Util.popularAleatorioNumeros(listaNumeros, 10, 100, 500);
            Util.exibirListaNumeros(listaNumeros);

            Console.WriteLine("\n");

            lista2Numeros.AddRange(listaNumeros);

            Util.popularAleatorioPalavras(listaPalavras, 10, 6);
            Util.exibirListaPalavras(listaPalavras);

        }

    }
}
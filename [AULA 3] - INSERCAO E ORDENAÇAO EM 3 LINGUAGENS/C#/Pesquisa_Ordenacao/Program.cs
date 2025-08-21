using System;

class Program
{
    static void Main(string[] args)
    {
        int tamanho = 10000;
        int[] listaBolha = new int[tamanho];
        int[] listaInsercao = new int[tamanho];
        int[] listaNormal = new int[tamanho];

        Util.PopularListaAleatoria(listaBolha, 100, 20000);
        Util.PopularListaAleatoria(listaInsercao, 100, 20000);
        Util.PopularListaAleatoria(listaNormal, 100, 20000);

        // Sort nativo do C#
        var tempoInicio = DateTime.Now;
        Array.Sort(listaNormal);
        var tempoFim = DateTime.Now;
        Console.WriteLine("Tempo ordenar por sort nativo: " + (tempoFim - tempoInicio).TotalSeconds + "s");

        // Bolha
        tempoInicio = DateTime.Now;
        Resultado resBolha = Ordenacao.Bolha(listaBolha);
        tempoFim = DateTime.Now;
        Console.WriteLine("Tempo ordenar por bolha: " + (tempoFim - tempoInicio).TotalSeconds + "s");
        Console.WriteLine("Comparações: " + resBolha.Comparacoes);
        Console.WriteLine("Trocas: " + resBolha.Trocas);

        // Inserção
        tempoInicio = DateTime.Now;
        Resultado resInsercao = Insercao.Ordenar(listaInsercao);
        tempoFim = DateTime.Now;
        Console.WriteLine("Tempo ordenar por insercao: " + (tempoFim - tempoInicio).TotalSeconds + "s");
        Console.WriteLine("Comparações: " + resInsercao.Comparacoes);
        Console.WriteLine("Trocas: " + resInsercao.Trocas);
    }
}

public class Insercao
{
    public static Resultado Ordenar(int[] vetor)
    {
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int n = vetor.Length;

        for (int i = 1; i < n; i++)
        {
            int tmp = vetor[i];
            int j = i - 1;
            while (j >= 0)
            {
                qtdComparacoes++;
                if (tmp < vetor[j])
                {
                    vetor[j + 1] = vetor[j];
                    qtdTrocas++;
                    j--;
                }
                else
                {
                    break;
                }
            }
            vetor[j + 1] = tmp;
            qtdTrocas++;
        }

        Console.WriteLine("Quantidade comparações: " + qtdComparacoes);
        Console.WriteLine("Quantidade trocas: " + qtdTrocas + "\n");

        return new Resultado(qtdComparacoes, qtdTrocas);
    }
}

public class Ordenacao
{
    public static Resultado Bolha(int[] lista)
    {
        bool houveTroca = true;
        long qtdComparacoes = 0;
        long qtdTrocas = 0;

        while (houveTroca)
        {
            houveTroca = false;
            for (int i = 0; i < lista.Length - 1; i++)
            {
                qtdComparacoes++;
                if (lista[i] > lista[i + 1])
                {
                    int tmp = lista[i];
                    lista[i] = lista[i + 1];
                    lista[i + 1] = tmp;
                    qtdTrocas++;
                    houveTroca = true;
                }
            }
        }

        return new Resultado(qtdComparacoes, qtdTrocas);
    }
}

public class Util
{
    public static void PopularListaAleatoria(int[] lista, int inicio, int fim)
    {
        Random rand = new Random();
        for (int i = 0; i < lista.Length; i++)
        {
            lista[i] = rand.Next(inicio, fim + 1);
        }
    }
}

public class Resultado
{
    public long Comparacoes { get; set; }
    public long Trocas { get; set; }

    public Resultado(long comparacoes, long trocas)
    {
        Comparacoes = comparacoes;
        Trocas = trocas;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Util {
    public static void popularListaAleatoria(List<Integer> lista, int quantidade, int inicio, int fim) {
        Random random = new Random();
        for (int i = 0; i < quantidade; i++) {
            lista.add(random.nextInt(fim - inicio + 1) + inicio);
        }
    }

    public static void exibirLista(List<Integer> lista, String frase) {
        System.out.println(frase);
        for (int item : lista) {
            System.out.println(item);
        }
    }
}

class Ordenacao {
    // Contadores do Quick (colocados dentro da classe)
    public static int qtdQuickComparacoes = 0;
    public static int qtdQuickTrocas = 0;

    public static int[] bolha(List<Integer> lista) {
        boolean houveTroca = true;
        int qtdComparacoes = 0, qtdTrocas = 0;

        while (houveTroca) {
            houveTroca = false;
            for (int i = 0; i < lista.size() - 1; i++) {
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i + 1)) {
                    int tmp = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, tmp);
                    houveTroca = true;
                    qtdTrocas++;
                }
            }
        }
        return new int[]{qtdComparacoes, qtdTrocas};
    }

    public static int[] selecao(List<Integer> lista) {
        int qtdComparacoes = 0, qtdTrocas = 0;

        for (int i = 0; i < lista.size() - 1; i++) {
            int posMenor = i;
            for (int j = i + 1; j < lista.size(); j++) {
                qtdComparacoes++;
                if (lista.get(j) < lista.get(posMenor)) {
                    posMenor = j;
                }
            }
            if (i != posMenor) {
                int tmp = lista.get(i);
                lista.set(i, lista.get(posMenor));
                lista.set(posMenor, tmp);
                qtdTrocas++;
            }
        }
        return new int[]{qtdComparacoes, qtdTrocas};
    }

    public static int[] insercao(List<Integer> lista) {
        int qtdComparacoes = 0, qtdTrocas = 0;

        for (int i = 1; i < lista.size(); i++) {
            int tmp = lista.get(i);
            int j = i - 1;

            while (j >= 0) {
                qtdComparacoes++;
                if (tmp < lista.get(j)) {
                    lista.set(j + 1, lista.get(j));
                    qtdTrocas++;
                    j--;
                } else {
                    break;
                }
            }
            lista.set(j + 1, tmp);
            qtdTrocas++;
        }
        return new int[]{qtdComparacoes, qtdTrocas};
    }

    public static int particiona(List<Integer> lista, int ini, int fim) {
        int i = ini;
        int j = fim;
        int pivo = i;

        while (j > i) {
            while (j > pivo) {
                qtdQuickComparacoes++;
                if (lista.get(j) > lista.get(pivo)) {
                    j--;
                } else {
                    break;
                }
            }

            if (j > pivo) {
                int tmp = lista.get(pivo);
                lista.set(pivo, lista.get(j));
                lista.set(j, tmp);
                qtdQuickTrocas++;
                pivo = j;
            }

            i++;
            while (i < pivo) {
                qtdQuickComparacoes++;
                if (lista.get(i) < lista.get(pivo)) {
                    i++;
                } else {
                    break;
                }
            }

            if (i < pivo) {
                int tmp = lista.get(pivo);
                lista.set(pivo, lista.get(i));
                lista.set(i, tmp);
                qtdQuickTrocas++;
                pivo = i;
            }
        }

        return pivo;
    }

    public static void quickSort(List<Integer> lista, int ini, int fim) {
        if (ini >= fim) return;
        int pivo = particiona(lista, ini, fim); 
        if (ini < pivo - 1) quickSort(lista, ini, pivo - 1);
        if (pivo + 1 < fim) quickSort(lista, pivo + 1, fim);
    }

    public static int[] quick(List<Integer> lista) {
        qtdQuickComparacoes = 0;
        qtdQuickTrocas = 0;
        if (lista.size() > 0) {
            quickSort(lista, 0, lista.size() - 1);
        }
        return new int[]{qtdQuickComparacoes, qtdQuickTrocas};
    }
}

public class Principal {
    public static void main(String[] args) {
        List<Integer> listaBolha = new ArrayList<>();
        List<Integer> listaSelecao = new ArrayList<>();
        List<Integer> listaInsercao = new ArrayList<>();
        List<Integer> listaQuick = new ArrayList<>();

        int tamanho = 1000;
        Util.popularListaAleatoria(listaBolha, tamanho, 10000, 20000);
        listaSelecao.addAll(listaBolha);
        listaInsercao.addAll(listaBolha);
        listaQuick.addAll(listaBolha);

        // Bolha
        long inicio = System.nanoTime();
        int[] resBolha = Ordenacao.bolha(listaBolha);
        long fim = System.nanoTime();
        System.out.println("Tempo bolha: " + (fim - inicio) / 1e6 + " ms");
        System.out.println("Comparações: " + resBolha[0] + ", Trocas: " + resBolha[1]);

        // Seleção
        inicio = System.nanoTime();
        int[] resSelecao = Ordenacao.selecao(listaSelecao);
        fim = System.nanoTime();
        System.out.println("Tempo selecao: " + (fim - inicio) / 1e6 + " ms");
        System.out.println("Comparações: " + resSelecao[0] + ", Trocas: " + resSelecao[1]);

        // Inserção
        inicio = System.nanoTime();
        int[] resInsercao = Ordenacao.insercao(listaInsercao);
        fim = System.nanoTime();
        System.out.println("Tempo insercao: " + (fim - inicio) / 1e6 + " ms");
        System.out.println("Comparações: " + resInsercao[0] + ", Trocas: " + resInsercao[1]);

        // Quick
        inicio = System.nanoTime();
        int[] resQuick = Ordenacao.quick(listaQuick); 
        fim = System.nanoTime();
        System.out.println();
        System.out.println("Tempo Quick: " + (fim - inicio) / 1e6 + " ms");
        System.out.println("Comparações: " + resQuick[0] + ", Trocas: " + resQuick[1]);
    }
}

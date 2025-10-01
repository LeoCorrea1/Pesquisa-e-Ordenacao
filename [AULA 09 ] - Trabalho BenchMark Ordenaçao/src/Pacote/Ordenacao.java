/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pacote;

/**
 *
 * @author Administrador
 */

public class Ordenacao {
    public static class Resultado {
        public long comparacoes;
        public long trocas;
        public long tempoMillis;  // tempo em milissegundos (opcional)

        public Resultado(long comparacoes, long trocas, long tempoMillis) {
            this.comparacoes = comparacoes;
            this.trocas = trocas;
            this.tempoMillis = tempoMillis;
        }

        @Override
        public String toString() {
            return "Comparações: " + comparacoes
                 + ", Trocas: " + trocas
                 + ", Tempo (ms): " + tempoMillis;
        }
    }

    // Método bolha (bubble sort)
    public static Resultado bolha(int[] a) {
        long comparacoes = 0;
        long trocas = 0;
        long t0 = System.currentTimeMillis();

        int n = a.length;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                comparacoes++;
                if (a[j] > a[j + 1]) {
                    // troca
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    trocas++;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }

        long t1 = System.currentTimeMillis();
        return new Resultado(comparacoes, trocas, t1 - t0);
    }

    // Método de seleção (selection sort)
    public static Resultado selecao(int[] a) {
        long comparacoes = 0;
        long trocas = 0;
        long t0 = System.currentTimeMillis();

        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int menorIdx = i;
            for (int j = i + 1; j < n; j++) {
                comparacoes++;
                if (a[j] < a[menorIdx]) {
                    menorIdx = j;
                }
            }
            if (menorIdx != i) {
                int tmp = a[i];
                a[i] = a[menorIdx];
                a[menorIdx] = tmp;
                trocas++;
            }
        }

        long t1 = System.currentTimeMillis();
        return new Resultado(comparacoes, trocas, t1 - t0);
    }

    // Método de inserção (insertion sort)
    public static Resultado insercao(int[] a) {
        long comparacoes = 0;
        long trocas = 0;
        long t0 = System.currentTimeMillis();

        int n = a.length;
        for (int i = 1; i < n; i++) {
            int chave = a[i];
            int j = i - 1;
            // mover elementos de a[0..i-1] que são maiores que chave
            while (j >= 0) {
                comparacoes++;
                if (a[j] > chave) {
                    a[j + 1] = a[j];
                    trocas++;
                    j--;
                } else {
                    break;
                }
            }
            a[j + 1] = chave;
            // Você pode ou não contar essa atribuição final como troca (a depender da convenção)
        }

        long t1 = System.currentTimeMillis();
        return new Resultado(comparacoes, trocas, t1 - t0);
    }

    // Método merge sort (divide e conquista)
    public static Resultado mergeSort(int[] a) {
        long t0 = System.currentTimeMillis();
        Contador c = new Contador();
        mergeSortRec(a, 0, a.length - 1, c);
        long t1 = System.currentTimeMillis();
        return new Resultado(c.comparacoes, c.trocas, t1 - t0);
    }

    private static void mergeSortRec(int[] a, int l, int r, Contador c) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSortRec(a, l, m, c);
            mergeSortRec(a, m + 1, r, c);
            merge(a, l, m, r, c);
        }
    }

    private static void merge(int[] a, int l, int m, int r, Contador c) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = a[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = a[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            c.comparacoes++;
            if (L[i] <= R[j]) {
                a[k++] = L[i++];
                c.trocas++;
            } else {
                a[k++] = R[j++];
                c.trocas++;
            }
        }
        while (i < n1) {
            a[k++] = L[i++];
            c.trocas++;
        }
        while (j < n2) {
            a[k++] = R[j++];
            c.trocas++;
        }
    }

    // Método quick sort
    public static Resultado quickSort(int[] a) {
        long t0 = System.currentTimeMillis();
        Contador c = new Contador();
        quickSortRec(a, 0, a.length - 1, c);
        long t1 = System.currentTimeMillis();
        return new Resultado(c.comparacoes, c.trocas, t1 - t0);
    }

    private static void quickSortRec(int[] a, int low, int high, Contador c) {
        if (low < high) {
            int p = partition(a, low, high, c);
            quickSortRec(a, low, p - 1, c);
            quickSortRec(a, p + 1, high, c);
        }
    }

    private static int partition(int[] a, int low, int high, Contador c) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            c.comparacoes++;
            if (a[j] <= pivot) {
                i++;
                // troca a[i] e a[j]
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                c.trocas++;
            }
        }
        // troca pivot para a posição correta
        int tmp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = tmp;
        c.trocas++;
        return i + 1;
    }

    // Classe auxiliar para contar comparações e trocas em métodos recursivos
    private static class Contador {
        long comparacoes = 0;
        long trocas = 0;
    }
}

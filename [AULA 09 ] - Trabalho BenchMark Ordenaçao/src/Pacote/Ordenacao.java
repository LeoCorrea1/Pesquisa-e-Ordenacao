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
        public long qtd_comparacoes;
        public long qtd_trocas;
        public long tempoMillis;  

        public Resultado(long qtd_comparacoes, long qtd_trocas, long tempoMillis) {
            this.qtd_comparacoes = qtd_comparacoes;
            this.qtd_trocas = qtd_trocas;
            this.tempoMillis = tempoMillis;
        }

        @Override
        public String toString() {
            return "Comparações: " + qtd_comparacoes
                 + ", Trocas: " + qtd_trocas
                 + ", Tempo (ms): " + tempoMillis;
        }
    }

    public static Resultado bolha(int[] lista) {
        long qtd_comparacoes = 0;
        long qtd_trocas = 0;
        long t0 = System.currentTimeMillis();

        boolean houve_troca = true;
        int tmp;
        while (houve_troca) {
            houve_troca = false;
            for (int i = 0; i < lista.length - 1; i++) {
                qtd_comparacoes++;
                if (lista[i] > lista[i + 1]) {
                    tmp = lista[i];
                    lista[i] = lista[i + 1];
                    lista[i + 1] = tmp;
                    qtd_trocas++;
                    houve_troca = true;
                }
            }
        }

        long t1 = System.currentTimeMillis();
        return new Resultado(qtd_comparacoes, qtd_trocas, t1 - t0);
    }
    
    
    public static Resultado selecao(int[] lista) {
        long qtd_comparacoes = 0;
        long qtd_trocas = 0;
        long t0 = System.currentTimeMillis();

        for (int i = 0; i < lista.length - 1; i++) {
            int posMenor = i;
            for (int j = i + 1; j < lista.length; j++) {
                qtd_comparacoes++;
                if (lista[j] < lista[posMenor]) {
                    posMenor = j;
                }
            }
            if (i != posMenor) {
                int tmp = lista[i];
                lista[i] = lista[posMenor];
                lista[posMenor] = tmp;
                qtd_trocas++;
            }
        }

        long t1 = System.currentTimeMillis();
        return new Resultado(qtd_comparacoes, qtd_trocas, t1 - t0);
    }

    public static Resultado insercao(int[] lista) {
    long qtd_comparacoes = 0;
    long qtd_trocas = 0;
    long t0 = System.currentTimeMillis();

    for (int i = 1; i < lista.length; i++) {
        int tmp = lista[i];
        int j = i - 1;

        boolean houve_movimento = false; 

        while (j >= 0) {
            qtd_comparacoes++;
            if (tmp < lista[j]) {
                lista[j + 1] = lista[j]; 
                qtd_trocas++;
                j--;
                houve_movimento = true;
            } else {
                break;
            }
        }

        lista[j + 1] = tmp; 
        if (houve_movimento) {
            qtd_trocas++;
        }
    }

    long t1 = System.currentTimeMillis();
    return new Resultado(qtd_comparacoes, qtd_trocas, t1 - t0);
}


    public static Resultado mergeSort(int[] lista) {
        long t0 = System.currentTimeMillis();
        Contador c = new Contador();
        mergeSortRec(lista, 0, lista.length - 1, c);
        long t1 = System.currentTimeMillis();
        return new Resultado(c.qtd_comparacoes, c.qtd_trocas, t1 - t0);
    }

    private static void mergeSortRec(int[] lista, int esq, int dir, Contador c) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergeSortRec(lista, esq, meio, c);
            mergeSortRec(lista, meio + 1, dir, c);
            merge(lista, esq, meio, dir, c);
        }
    }

    private static void merge(int[] lista, int esq, int meio, int dir, Contador c) {
        int n1 = meio - esq + 1;
        int n2 = dir - meio;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = lista[esq + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = lista[meio + 1 + j];
        }

        int i = 0, j = 0, k = esq;
        while (i < n1 && j < n2) {
            c.qtd_comparacoes++;
            if (L[i] <= R[j]) {
                lista[k++] = L[i++];
                c.qtd_trocas++;
            } else {
                lista[k++] = R[j++];
                c.qtd_trocas++;
            }
        }
        while (i < n1) {
            lista[k++] = L[i++];
            c.qtd_trocas++;
        }
        while (j < n2) {
            lista[k++] = R[j++];
            c.qtd_trocas++;
        }
    }

    public static Resultado quickSort(int[] lista) {
        long t0 = System.currentTimeMillis();
        Contador c = new Contador();
        quickSortRec(lista, 0, lista.length - 1, c);
        long t1 = System.currentTimeMillis();
        return new Resultado(c.qtd_comparacoes, c.qtd_trocas, t1 - t0);
    }

    private static void quickSortRec(int[] lista, int esq, int dir, Contador c) {
        if (esq < dir) {
            int pivo = particiona(lista, esq, dir, c);
            quickSortRec(lista, esq, pivo - 1, c);
            quickSortRec(lista, pivo + 1, dir, c);
        }
    }

    private static int particiona(int[] lista, int esq, int dir, Contador c) {
        int pivo = lista[dir];
        int i = esq - 1;
        for (int j = esq; j < dir; j++) {
            c.qtd_comparacoes++;
            if (lista[j] <= pivo) {
                i++;
                int tmp = lista[i];
                lista[i] = lista[j];
                lista[j] = tmp;
                c.qtd_trocas++;
            }
        }
        int tmp = lista[i + 1];
        lista[i + 1] = lista[dir];
        lista[dir] = tmp;
        c.qtd_trocas++;
        return i + 1;
    }

    private static class Contador {
        long qtd_comparacoes = 0;
        long qtd_trocas = 0;
    }
}

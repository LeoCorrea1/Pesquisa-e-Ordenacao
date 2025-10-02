    // - Armazene milhoes de numeros inteiros ( desordnados )
    // - localize o menor numero gerado
    // - retorne o numero
    // - temporize o processo
    // - contabilize as trocas e comparaçoes
    // - com sort nativo ou comparar a lista inteira


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

        public static void exibirLista(List<Integer> lista, String frase, int limite) {
            System.out.println(frase);
            for (int i = 0; i < Math.min(lista.size(), limite); i++) {
                System.out.println(lista.get(i));
            }
            if (lista.size() > limite) {
                System.out.println("... (" + (lista.size() - limite) + " restantes)");
            }
        }
    }

    public class Principal {
        public static void main(String[] args) {

            int tamanho = 1_000_000; 
            List<Integer> lista = new ArrayList<>();
            Util.popularListaAleatoria(lista, tamanho, 0, 1_000_000);

            Util.exibirLista(lista, "Lista Desordenada:", 10);

            long inicio = System.currentTimeMillis();

            int menor = Integer.MAX_VALUE;
            int comparacoes = 0;
            for (int numero : lista) {
                comparacoes++;
                if (numero < menor) {
                    menor = numero;
                }
            }

            long fim = System.currentTimeMillis();

            System.out.println("Menor numero: " + menor);
            System.out.println("Tempo gasto: " + (fim - inicio) + " ms");
            System.out.println("Comparacoes: " + comparacoes);
            System.out.println("-----------------------------------\n");


            System.out.println("lista ordenando nativamente");
            inicio = System.currentTimeMillis();
            lista.sort(Integer::compareTo);
            fim = System.currentTimeMillis();
            Util.exibirLista(lista, "Lista Ordenada:", 10);
            System.out.println("Tempo gasto na ordenacao: " + (fim - inicio) + " ms");
            System.out.println("Menor numero: " + menor);



        }
    }

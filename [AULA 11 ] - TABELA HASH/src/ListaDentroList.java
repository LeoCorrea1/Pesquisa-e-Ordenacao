import java.util.ArrayList;
import java.util.Scanner;

class Util {
    public static int hash(int numero, int tamanho) {
        return numero % tamanho;
    }
}

public class ListaDentroList {
    public static void main(String[] args) {
        // Cria um vetor (array) de 10 posições, cada uma será uma lista
        ArrayList<Integer>[] tabela = new ArrayList[10];

        // Inicializa cada posição do vetor com uma nova lista
        for (int i = 0; i < tabela.length; i++) {
            tabela[i] = new ArrayList<>();
        }

        Scanner teclado = new Scanner(System.in);
        int numero, endereco;

        // Inserir 5 números na tabela de hash
        for (int i = 0; i < 5; i++) {
            System.out.print("Numero: ");
            numero = teclado.nextInt();

            // Calcular o endereço de dispersão do número
            endereco = Util.hash(numero, tabela.length);
            System.out.println("Endereco gerado: " + endereco);

            if (!tabela[endereco].contains(numero)) {
                tabela[endereco].add(numero);
                System.out.println("Numero " + numero + " inserido na posicao " + endereco);
            } else {
                System.out.println("Numero " + numero + " ja existe na posicao " + endereco);
            }
        }
        
        System.out.println("\nEstado atual da tabela:");
        for (int i = 0; i < tabela.length; i++) {
            System.out.println("Posicao " + i + ": " + tabela[i]);
        }
       
        System.out.println("\nBuscando números...");
        
            System.out.print("Numero a buscar: ");
            numero = teclado.nextInt();

            endereco = Util.hash(numero, tabela.length);

            if (tabela[endereco].contains(numero)) {
                System.out.println("Numero " + numero + " encontrado na posicao " + endereco);
            } else {
                System.out.println("Numero " + numero + " nao encontrado.");
            }

        System.out.println("\nRemovendo numeros...");

            System.out.print("Numero a remover: ");
            numero = teclado.nextInt();

            endereco = Util.hash(numero, tabela.length);

            if (tabela[endereco].contains(numero)) {
                tabela[endereco].remove(Integer.valueOf(numero));
                System.out.println("Numero " + numero + " removido da posicao " + endereco);
            } else {
                System.out.println("Numero " + numero + " não encontrado para remocao.");
            
        }

        System.out.println("\nEstado final da tabela:");
        for (int i = 0; i < tabela.length; i++) {
            System.out.println("Posicao " + i + ": " + tabela[i]);
        }

        teclado.close();
    }
}

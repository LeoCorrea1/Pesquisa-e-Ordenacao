package Codigo1;

import java.util.ArrayList;
import java.util.Random;


public class Util {
    /***
     * metodo estatico que popula uma lista de numeros inteiros com valores aleatorios
     * @param lista estrytyra de armazenamento dos numeros
     * @param quantidade de numeros a serem gerados
     * @param inicio valor nicial do random
     * @param fim valor final do random
     */
    public static void popularAleatorioNumeros(ArrayList<Integer> lista, long quantidade , int inicio , int fim) {
        Random gerador = new Random();
        for ( ;quantidade > 0 ; quantidade --) {
            lista.add(gerador.nextInt(inicio,fim));
        }
    }

    /***
     * Método estatico que gera palavras alaeatorias
     * @param lista armazena as palavras geradas
     * @param quantidade de palavras a serem geradas
     * @param tamanho tamanho da palavras a serem geradas
     */
    public static void popularAleatorioPalavras(ArrayList<String> lista, long quantidade, int tamanho ) {
        String letras = "abcdefghijklmnopqrstuvwxyz ";
        Random gerador = new Random();


        for(;quantidade > 0 ; quantidade --) {
            String palavraGerada = "";
            char letraSorteada;

            for(int i = 0 ; i< tamanho ; i++) {
                letraSorteada = letras.charAt(gerador.nextInt(letras.length())) ;
                palavraGerada = palavraGerada + letraSorteada;
            }
            lista.add(palavraGerada);
        }
    }

    /***
     * Método estatico que exibe uma lista de numeros inteiros
     * @param lista contendo numeros inteiros
     */

    public static void exibirListaNumeros(ArrayList<Integer> lista) {
        for (Integer item : lista) {
            System.out.println(item);
        }


    }

    /***
     * método estatco que exibe uma lista de palavaras
     * @param lista contendo palavras
     */
    public static void exibirListaPalavras(ArrayList<String> lista) {

        for (String item : lista) {
            System.out.println(item);
        }

    }
}

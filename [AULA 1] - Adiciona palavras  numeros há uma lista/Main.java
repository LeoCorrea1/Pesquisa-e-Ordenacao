package Codigo1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> listaNumeros = new ArrayList<>();
        ArrayList<Integer> lista2Numeros = new ArrayList<>();
        ArrayList<String> listaPalavras = new ArrayList<>();

    Util.popularAleatorioNumeros(listaNumeros,10,100,500);
    Util.exibirListaNumeros(listaNumeros);

    System.out.println("\n");

    lista2Numeros.addAll(listaNumeros);
    lista2Numeros = (ArrayList<Integer>) lista2Numeros.clone();

    Util.popularAleatorioPalavras(listaPalavras , 10 , 6);
    Util.exibirListaPalavras(listaPalavras);





    }
}
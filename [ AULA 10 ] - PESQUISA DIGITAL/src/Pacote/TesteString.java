package Pacote;

public class TesteString {

    public static void main(String[] args) {
        
        StringBuffer pai = new StringBuffer("00011");
        StringBuffer mae = new StringBuffer("99977");

        System.out.println("Pai... " + pai);
        System.out.println("Mae... " + mae);

        System.out.println("Tamanho pai... " + pai.length());
        System.out.println("Tamanho mae... " + mae.length());

        
        String metadePai1 = pai.substring(0, (int)pai.length()/2);
        String metadePai2 = pai.substring((int)pai.length()/2, pai.length());
        
        String metadeMae1 = mae.substring(0, (int)mae.length()/2);
        String metadeMae2 = mae.substring((int)mae.length()/2, mae.length());
        
        System.out.println("Primeira metade pai... " + pai.substring(0, (int)pai.length()/2));
        System.out.println("Segunda metade pai... " + pai.substring((int)pai.length()/2, pai.length()));
        System.out.println("\n");
        System.out.println("FILHO 1 : " + metadePai1 + metadeMae2);
        System.out.println("FILHO 2 : " +metadeMae1 + metadePai2);

    }
}

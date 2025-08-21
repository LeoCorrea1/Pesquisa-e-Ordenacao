package Java;

public class Ordenacao {
    public static Resultado bolha(int[] lista) {
        boolean houveTroca = true;
        long qtdComparacoes = 0;
        long qtdTrocas = 0;

        while (houveTroca) {
            houveTroca = false;
            for (int i = 0; i < lista.length - 1; i++) {
                qtdComparacoes++;
                if (lista[i] > lista[i + 1]) {
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
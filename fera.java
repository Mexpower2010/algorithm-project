import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class fera {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int qtdCasoTeste = S.nextInt();
        for (int i = 0; i < qtdCasoTeste; i++) {
            Map <String, Double> opCompra = new HashMap<>(); 
            int qtdOpCompra = S.nextInt();
            for (int j = 0; j < qtdOpCompra; j++) {
                opCompra.put(S.next(), S.nextDouble());
            }
            int qtdLista = S.nextInt();
            Map <String, Integer> ListaCompra = new HashMap<>(); 
            for (int j = 0; j < qtdLista; j++) {
                ListaCompra.put(S.next(), S.nextInt());
            }
            double qtdDinDin = 0;
            for (String produto : ListaCompra.keySet()) {
                qtdDinDin += ListaCompra.get(produto)*opCompra.get(produto);
            }
            System.out.printf("R$ %.2f\n",qtdDinDin);
        }
    }
}

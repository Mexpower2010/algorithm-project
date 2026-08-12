package aulaSetMapHash.Lista;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
public class bee1281 {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int qtdCasosTeste = S.nextInt();
        for (int i = 0; i < qtdCasosTeste; i++) {
            Map <String,Double>produtosDisponiveis = new HashMap<>();
            int qtdProdutos = S.nextInt();
            for (int j = 0; j < qtdProdutos; j++) {
                produtosDisponiveis.put(S.next(), S.nextDouble());
            }
            Map <String,Integer>listaCompras = new HashMap<>();
            int tamanhoLista = S.nextInt();
            for (int j = 0; j < tamanhoLista; j++) {
                listaCompras.put(S.next(), S.nextInt());
            }
            double dinheiroLevar = 0;
            for (String produto : listaCompras.keySet()) {
                dinheiroLevar += listaCompras.get(produto)*produtosDisponiveis.get(produto); 
            }
            System.out.printf("R$ %.2f\n"+dinheiroLevar);
        }
    }
}
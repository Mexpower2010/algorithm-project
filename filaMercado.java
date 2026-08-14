import java.util.Scanner;

public class filaMercado {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int[] atendentes = new int[S.nextInt()];
        int[] clientes = new int[S.nextInt()];
        for (int i = 0; i < atendentes.length; i++) {
            atendentes[i] = S.nextInt();
        }
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = S.nextInt();
        }
        
    }
}

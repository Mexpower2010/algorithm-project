package simulado08_05;
import java.util.Scanner;
public class vo {
    public static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int cont = 1;
        while (true) {
            int n = S.nextInt();
            if (n<=0) {
                break;
            }
            int sobra = 0;
            System.out.println("Teste "+cont);
            for (int index = 0; index < n; index++) {
                int j = S.nextInt();
                int k = S.nextInt();
                sobra += j-k;
                System.out.println(sobra);
            }
            cont++;
            System.out.println();
        }
    }
}

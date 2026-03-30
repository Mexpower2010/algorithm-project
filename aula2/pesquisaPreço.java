package aula2;
import java.util.Scanner;
public class pesquisaPreço {
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int cont = 0;
        for (int i = 0; i < sc.nextInt(); i++) {
            String nomeE = sc.next();
            double alcol = sc.nextDouble();
            double gasosa = sc.nextDouble();
            if (alcol<=gasosa*0.7) {
                System.out.println(nomeE);
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("*");
        }
    }
}

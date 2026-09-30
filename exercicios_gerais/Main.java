import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner l = new Scanner(System.in);
    public static void main(String[] args) {
        int n = l.nextInt();
        int n1 = l.nextInt();
        ArrayList<Integer> jaVisitados = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            jaVisitados.add(l.nextInt());
        }
        int valor = 0;
        for (int i = 0; i < n; i++) {
            valor = l.nextInt();
            if (jaVisitados.contains(valor)) {
                System.out.println(0);
            } else {
                System.out.println(1);
                jaVisitados.add(valor);
            }
        }
    }
}

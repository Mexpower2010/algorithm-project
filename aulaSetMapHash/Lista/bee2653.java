package aulaSetMapHash.Lista;

import java.util.HashSet;
import java.util.Scanner;

public class bee2653 {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        HashSet<String> joias = new HashSet<>();
        while (S.hasNext()) {
            String texto = S.nextLine();
            joias.add(texto);
        }
        System.out.println(joias.size());
    }
}

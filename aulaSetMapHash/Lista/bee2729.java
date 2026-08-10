package aulaSetMapHash.Lista;
import java.util.HashSet;
import  java.util.Scanner;
import java.util.TreeSet;
public class bee2729 {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int n = S.nextInt();
        S.nextLine();
        for (int i = 0; i < n; i++) {
            TreeSet <String> palavras = new TreeSet<>();
            String[] linha = S.nextLine().split(" ");
            for (String string : linha) {
                palavras.add(string);
            }
            System.out.println(String.join(" ", palavras));
            System.out.println();
        }
        
    }
}

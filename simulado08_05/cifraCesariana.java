package simulado08_05;
import java.util.Scanner;
public class cifraCesariana {
    public final static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            char[] c = s.next().toCharArray();
            int k = s.nextInt();
            for (int j = 0; j < c.length; j++) {
                c[j] = (char)(((((int)c[j] - 65)+k)%26)+65);
            }
            System.out.println(c.toString());
        }
    }
}
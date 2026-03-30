package aula2;
import java.util.Scanner;
public class mediaMediana {
    final static public Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        a = Math.min(a, b);
        b = Math.max(a, b);
        int c = 2*a-b;
        System.out.println(c);
    }
}

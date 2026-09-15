import java.util.Scanner;
public class espelho {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int qtdVz = S.nextInt();
        for (int i = 0; i < qtdVz; i++) {
            StringBuilder s = new StringBuilder();
            int num1 = S.nextInt();
            int num2 = S.nextInt();
            for (int j = num1; j <= num2; j++) {
                s.append(String.valueOf(j));
                System.out.print(j);
            }
            s.reverse();
            System.out.println(s);
        }
    }
}

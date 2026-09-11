import java.util.Scanner;
public class palhaco {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int num = S.nextInt();
        int comparacao = S.nextInt();
        boolean foi = true;
        for (int i = 0; i < num-1; i++) {
            int num_comparacao = S.nextInt();
            if (comparacao<num_comparacao) {
                System.out.println('N');
                foi = false;
                break;
            }
        }
        if (foi) {
            System.out.println('S');
        }
    }
}
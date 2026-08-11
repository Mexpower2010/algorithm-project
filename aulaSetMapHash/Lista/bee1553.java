package aulaSetMapHash.Lista;

import java.util.Scanner;

public class bee1553 {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            int n = S.nextInt();
            int f = S.nextInt();
            if (f==0&&n==0) {
                break;
            }
            int [] vetorF = new int[100];
            for (int i = 0; i < n; i++) {
                int indice = S.nextInt()-1;
                vetorF[indice]++;
            }
            int qtdAdd=0;
            for (int i = 0; i < vetorF.length; i++) {
                if (vetorF[i]>=f) {
                    qtdAdd++;
                }
            }
            System.out.println(qtdAdd);

        }
    }
}

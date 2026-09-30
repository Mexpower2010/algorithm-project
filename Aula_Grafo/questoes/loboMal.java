package questoes;

import java.util.Scanner;

public class loboMal {
    public final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int colunas = S.nextInt();
        int linhas = S.nextInt();
        char[][] mapa = new char[colunas][linhas];
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {
                mapa[i][j] = S.next().charAt(0);                
            }
        }
        
    }
}

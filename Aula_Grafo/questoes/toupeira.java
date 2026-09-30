package questoes;
import java.util.Scanner;
public class toupeira {
    public final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int qtdSalas = S.nextInt();
        int qtdTuneis = S.nextInt();
        int [][] mapa = new int[qtdSalas][qtdSalas];
        for (int i = 0; i < qtdTuneis; i++) {
            int sala1 = S.nextInt()-1;
            int sala2 = S.nextInt()-1;
            mapa[sala1][sala2] = 1;
            mapa[sala2][sala1] = 1;
        }
        int qtdSugestoes = S.nextInt();
        int qtdSugestoesPossiveis = 0;
        for (int i = 0; i < qtdSugestoes; i++) {
            boolean ehPossivel = true;
            int [] vetorPasseio = new int[S.nextInt()];
            for (int j = 0; j < vetorPasseio.length; j++) {
                vetorPasseio[j] = S.nextInt()-1;
            }
            for (int j = 1; j < vetorPasseio.length; j++) {
                if (mapa[vetorPasseio[j-1]][vetorPasseio[j]]!=1) {
                    ehPossivel = false;
                    break;
                }
            }
            if (ehPossivel) {
                qtdSugestoesPossiveis++;
            }
        }
        System.out.println(qtdSugestoesPossiveis);
    }
}

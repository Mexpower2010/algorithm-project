package questoes;
import java.util.ArrayList;
import java.util.Scanner;
public class gincana {
    public final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int qtdCrioncias = S.nextInt();
        int qtdAmizades = S.nextInt();
        ArrayList<Integer>[] conexoes = new ArrayList[qtdCrioncias];
        for (int i = 0; i < conexoes.length; i++) {
            conexoes[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < qtdAmizades; i++) {
            int amizade1 = S.nextInt()-1;
            int amizade2 = S.nextInt()-1;
            conexoes[amizade1].add(amizade2);
            conexoes[amizade2].add(amizade1);
        }
        int[] vetorTurma = new int[qtdCrioncias];
        int qtdTimes = 0;
        for (int i = 0; i < vetorTurma.length; i++) {
            if (vetorTurma[i]==0) {
                setarAmigosTime(conexoes, vetorTurma, i);
                qtdTimes++;
            }
        }
        System.out.println(qtdTimes);
    }
    public static void setarAmigosTime(ArrayList<Integer>[] conexoes, int[] vetorTurma, int pessoa){
        vetorTurma[pessoa]=1;
                for (int amigos : conexoes[pessoa]) {
                    if (vetorTurma[amigos]==0) {
                        setarAmigosTime(conexoes, vetorTurma, amigos);
                    }
                }
    }
}

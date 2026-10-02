package questoes;
import java.util.ArrayList;
import java.util.Scanner;

public class Maina {
    public final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int qtdCasas = S.nextInt();
        int qtdCaminhos = S.nextInt();
        int casaDonaFormigaComeca = S.nextInt() - 1;

        int[] valorCasas = new int[qtdCasas];
        for (int i = 0; i < valorCasas.length; i++) {
            valorCasas[i] = S.nextInt();
        }

        ArrayList<Integer>[] caminhos = new ArrayList[qtdCasas];
        for (int i = 0; i < caminhos.length; i++) {
            caminhos[i] = new ArrayList<>();
        }

        for (int i = 0; i < qtdCaminhos; i++) {
            int casa1 = S.nextInt() - 1;
            int casa2 = S.nextInt() - 1;
            if (valorCasas[casa1] > valorCasas[casa2]) {
                caminhos[casa1].add(casa2);
            }
            if (valorCasas[casa2] > valorCasas[casa1]) {
                caminhos[casa2].add(casa1);
            }
        }

        int maiorNum = 0;
        for (int casa : caminhos[casaDonaFormigaComeca]) {
            ArrayList<Integer> visitados = new ArrayList<>();
            int resultado = setarVisitado(visitados, casa, caminhos, 1);
            maiorNum = Math.max(maiorNum, resultado);
        }
        System.out.println(maiorNum);
    }

    public static int setarVisitado(ArrayList<Integer> visitados, int casaAtual, ArrayList<Integer>[] caminhos, int qtdCaminhos){
        visitados.add(casaAtual);
        int melhor = qtdCaminhos;
        for (int casa : caminhos[casaAtual]) {
            if (!visitados.contains(casa)) {
                int resultado = setarVisitado(visitados, casa, caminhos, qtdCaminhos + 1);
                melhor = Math.max(melhor, resultado);
            }
        }
        return melhor;
    }
}
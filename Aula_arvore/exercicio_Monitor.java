import java.util.ArrayList;
import java.util.Scanner;

public class exercicio_Monitor {
    static ArrayList<Integer>[] filhos;
    static int[] tamanhoSubarvore;
    static int folhas = 0;
    static int maiorProfundidade = 0;

    static void dfs(int no, int profundidade) {
        maiorProfundidade = Math.max(maiorProfundidade, profundidade);
        tamanhoSubarvore[no] = 1;

        if (filhos[no].size() == 0) {
            folhas++;
        }

        for (int filho : filhos[no]) {
            dfs(filho, profundidade + 1);
            tamanhoSubarvore[no] += tamanhoSubarvore[filho];
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int n = entrada.nextInt();
        filhos = new ArrayList[n + 1];
        tamanhoSubarvore = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            filhos[i] = new ArrayList<>();
        }

        for (int filho = 2; filho <= n; filho++) {
            int pai = entrada.nextInt();
            filhos[pai].add(filho);
        }

        dfs(1, 0);

        System.out.println("Altura: " + maiorProfundidade);
        System.out.println("Folhas: " + folhas);
        System.out.println("Tamanho da subarvore de cada no:");

        for (int i = 1; i <= n; i++) {
            System.out.println(i + ": " + tamanhoSubarvore[i]);
        }

        entrada.close();
    }
}
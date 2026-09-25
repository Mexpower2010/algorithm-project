import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs_dfs  {
    static ArrayList<Integer>[] filhos;

    static void dfs(int no) {
        System.out.println("Visitando " + no);

        for (int filho : filhos[no]) {
            dfs(filho);
        }
    }

    static void bfs(int raiz) {
        Queue<Integer> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            int atual = fila.poll();
            System.out.println("Visitando " + atual);

            for (int filho : filhos[atual]) {
                fila.add(filho);
            }
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int n = entrada.nextInt();
        filhos = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            filhos[i] = new ArrayList<>();
        }

        for (int filho = 2; filho <= n; filho++) {
            int pai = entrada.nextInt();
            filhos[pai].add(filho);
        }

        System.out.println("DFS:");
        dfs(1);

        System.out.println("BFS:");
        bfs(1);

        entrada.close();
    }
}
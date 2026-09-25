import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class exercicio_convite {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int n = entrada.nextInt();
        int origem = entrada.nextInt();
        int limite = entrada.nextInt();

        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = entrada.nextInt();
            int b = entrada.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        int[] distancia = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distancia[i] = -1;
        }

        Queue<Integer> fila = new LinkedList<>();
        fila.add(origem);
        distancia[origem] = 0;

        int resposta = 0;

        while (!fila.isEmpty()) {
            int atual = fila.poll();

            if (distancia[atual] <= limite) {
                resposta++;
            } else {
                continue;
            }

            for (int vizinho : adj[atual]) {
                if (distancia[vizinho] == -1) {
                    distancia[vizinho] = distancia[atual] + 1;
                    fila.add(vizinho);
                }
            }
        }

        System.out.println(resposta);
        entrada.close();
    }
}
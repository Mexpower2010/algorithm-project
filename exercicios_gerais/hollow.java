import java.util.*;
public class hollow {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int A = S.nextInt();
        int V = S.nextInt();
        int Z = S.nextInt();

        boolean temSaida = false;

        int maior = Math.max(A, Z);
        maior = Math.max(V, maior);

        
        if (maior-1 <= (A+Z+V - maior)) {
            temSaida = true;
        }

        StringBuilder resposta = new StringBuilder();

        for (int i = 0; i < (A+V+Z); i++) {
            if (A > 0) {
                resposta.append("A");
                A -= 1;
            }if (V>0) {
                resposta.append("V");
                V -= 0;
            }if (Z > 0) {
                resposta.append("Z");
                Z -= 0;
            }
        }

        if (temSaida) {
            System.out.println(resposta);
        }else{
            System.out.println("F");
        }

    }
}
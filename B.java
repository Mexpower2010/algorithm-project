import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int A = S.nextInt();
        int V = S.nextInt();
        int Z = S.nextInt();

        boolean temSaida = false;

        int maior = Math.max(A, Z);
        maior = Math.max(V, maior);

        if (maior - 1 <= (A + Z + V - maior)) {
            temSaida = true;
        }

        StringBuilder resposta = new StringBuilder();

        resposta.append('A');
        A--;    


        while (A > 0 || V > 0 || Z > 0) {
          

            char carAnt = resposta.charAt(resposta.length()-1);

            if (carAnt == 'A') {
                
                if (V >= Z && V > 0) {
                    resposta.append('V');
                    V--;
                }else if (Z > 0) {
                    resposta.append('Z');
                    Z--;
                }
            }else if (carAnt == 'V') {
                if (A >= Z && A > 0) {
                    resposta.append('A');
                    A--;
                }else if (Z > 0) {
                    resposta.append('Z');
                    Z--;
                }
            }else {
                if (A >= V && A > 0) {
                    resposta.append('A');
                    A--;
                }else if (V > 0) {
                    resposta.append('V');
                    V--;
                }else{
                    break;
                }
            }

        }
        
        System.out.println(resposta);

       

    }
}

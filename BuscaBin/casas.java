package BuscaBin;
import java.util.Scanner;
public class casas {
    final static public Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int qtdCasas = S.nextInt();
        int[] casasV = new int[qtdCasas];
        for (int i = 0; i < qtdCasas; i++) {
            casasV[i] = S.nextInt();
        }
        int numSoma = S.nextInt();
        for (int i = 0; i < casasV.length; i++) {
            int numQueFalta = numSoma-casasV[i];
            int inicio = i+1;
            int fim = casasV.length - 1;
            boolean encotro = false;
            while (inicio<=fim) {
                int meio = fim - (inicio-fim)/2;
                if (casasV[meio] == numQueFalta) {
                    encotro = true;
                    break;
                }else if(casasV[meio]>numQueFalta){
                    fim = meio-1;
                } else{
                    inicio = meio+1;
                }
            }
            if (encotro) {
                System.out.println(casasV[i]+""+numQueFalta);
                break;
            } 
        }
        
    }
}
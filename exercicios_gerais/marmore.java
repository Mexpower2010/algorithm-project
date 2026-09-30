import java.util.Arrays;
import java.util.Scanner;
public class marmore {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            int qtdMarmore = S.nextInt();
            int qtdBusca = S.nextInt();
            int qtdCasoTeste = 1;
            if (qtdBusca==qtdMarmore&&qtdBusca==0) {
                break;
            }
            int[] Marmores = new int[qtdMarmore];
            for (int i = 0; i < qtdMarmore; i++) {
                Marmores[i]=S.nextInt();
            }
            int[] busca= new int[qtdBusca];
            for (int i = 0; i < busca.length; i++) {
                busca[i]=S.nextInt();
            }
            Arrays.sort(Marmores);
            System.out.println("CASE# "+qtdCasoTeste+":");
            for (int i = 0; i < busca.length; i++) {
                int inicio = 0;                      
                int fim = Marmores.length - 1;     
                int acho = -1;

                while (inicio <= fim) {
                    int meio = inicio + (fim - inicio) / 2; 
                    if (Marmores[meio] == busca[i]) {
                        acho = meio;
                        fim = meio - 1; 
                    } else if (Marmores[meio] < busca[i]) {
                        inicio = meio + 1; 
                    }else{ 
                        fim = meio - 1; 
                    }
                }
                if (acho==-1) {
                    System.out.println(busca[i]+" not found");
                }else{
                    System.out.println(busca[i]+" found at "+(acho+1));
                }
            }
            qtdCasoTeste++;
        
        }
    }
}


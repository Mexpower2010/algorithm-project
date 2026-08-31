package aulaSetMapHash.Lista;

import java.util.HashMap;
import java.util.Scanner;

public class bee1260 {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int numCasoTeste = S.nextInt();
        HashMap <String, Integer> arvores = new HashMap<>();
        S.nextLine();
        while (S.hasNext()) {
            String arvore = S.nextLine();
            if (arvore.contains("")) {
                for (String arvoreI : arvores.keySet()) {
                    double porcent = (double)(arvores.get(arvoreI)/arvores.size())*100;
                    System.out.printf("%s %.4f\n",arvoreI, porcent);
                    
                }
                arvores = new HashMap<>();
                numCasoTeste--;
                if (numCasoTeste==0) {
                    break;
                }
                continue;
            }
            arvores.merge(arvore, 1, Integer::sum);
        }
        for (String arvore : arvores.keySet()) {
            double porcent = (double)(arvores.get(arvore)/arvores.size())*100;
            System.out.printf("%s %.4f\n",arvore, porcent);
        }
    }
}

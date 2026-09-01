package aulaSetMapHash.Lista;

import java.util.TreeMap;
import java.util.Scanner;

public class bee1260 {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int numCasoTeste = S.nextInt();
        S.nextLine(); S.nextLine();
        for (int i = 0; i < numCasoTeste; i++) {
            TreeMap <String, Integer> arvores = new TreeMap<>();
            int totalArvores = 0;

            while (S.hasNextLine()) {
                String arvore = S.nextLine();
                if (arvore.isEmpty()) {
                    break;
                }
                arvores.merge(arvore, 1, Integer::sum);
                totalArvores++;
            }
            for (String chaveArvore : arvores.keySet()) {
                double porcentagenArvore = (double)((double) arvores.get(chaveArvore)/(double)totalArvores)*100.0;
                System.out.printf("%s %.4f\n", chaveArvore, porcentagenArvore);
            }
            System.out.println();
            
        }
    }
}

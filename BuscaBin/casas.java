package BuscaBin;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.function.IntFunction;

public class casas {
    final static public Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int qtdCasas = S.nextInt();
        LinkedHashSet<Integer> casas = new LinkedHashSet();
        int[] casasV = new int[qtdCasas];
        for (int i = 0; i < qtdCasas; i++) {
            casasV[i] = S.nextInt();
            casas.add(casasV[i]);
        }
        int numSoma = S.nextInt();
        int inicio = 0;
        int fim = casasV.length - 1;
        int meio = fim - ((inicio+fim)/2);
        while (true) {
            int Num2 = casasV[meio]-numSoma;
            if (casas.contains(Num2)) {
                System.out.println(meio+" "+Num2);
            }
        }
    }
}
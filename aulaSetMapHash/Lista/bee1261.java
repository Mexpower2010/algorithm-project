package aulaSetMapHash.Lista;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class bee1261 {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int qtdPalavras = S.nextInt();
        int qtdCargos = S.nextInt();
        Map<String, Integer> palavrasChave = new HashMap<>();
        for (int i = 0; i < qtdPalavras; i++) {
            palavrasChave.put(S.next(), S.nextInt());
        }
        long salario = 0;
        int i = 0; 
        while (i<qtdCargos) {
            String palavra = S.next();
            if (palavra.equals(".")) {
                System.out.println(salario);
                salario = 0;
                i++;
            }else{
            if (palavrasChave.containsKey(palavra)) {
                salario+=palavrasChave.get(palavra);
            }
            }
        }
    }    
}

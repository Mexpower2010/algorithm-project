package simulado08_05;
import java.util.Scanner;
public class frase {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        s.nextLine();
        for (int index = 0; index < n; index++) {
            char[] frase = s.nextLine().toCharArray();
            int[] presenca = new int[26];
            for (int i = 0; i < frase.length; i++) {
                if (frase[i]>='a'&&frase[i]<='z') {
                    presenca[(int)frase[i]-97]++;
                }
            }
            int cont = 0;
            for (int i = 0; i < presenca.length; i++) {
                if (presenca[i]>0) {
                    cont++;
                }
            }
            if (cont==26) {
                System.out.println("frase completa");
            }else if (cont>=13 ) {
                System.out.println("frase quase completa");
            }else{ 
                System.out.println("frase mal elaborada");
            }
            
        }
    }
}

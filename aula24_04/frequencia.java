import java.util.Scanner;
public class frequencia {
    public final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int v []= new int[S.nextInt()];
        int maior = Integer.MIN_VALUE;
        for (int i = 0; i < v.length; i++) {
            v[i] = S.nextInt();
            if (maior<v[i]) {
                maior=v[i];
            }
        }
        int freq[] = new int[maior+1];
        for (int i = 0; i < v.length; i++) {
            freq[v[i]]++;
        }
        for (int i = 0; i < freq.length; i++) {
            
            System.out.println(i+" aparece "+freq[i]+" vez(es)");
            
        }
    }
    
}

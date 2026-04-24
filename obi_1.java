import java.util.Scanner;
public class obi_1 {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int n = S.nextInt();
        int [] v = lerv(n);
        long inicio = System.nanoTime();
        int maior = acharMaior(v);
        long fim = System.nanoTime();
        System.out.println("TEMPO : (ns) "+ (fim - inicio));
        System.out.println(maior);
    }
    public static int acharMaior(int[] v) {
        int maior = Integer.MIN_VALUE;
        for (int i = 0; i < v.length; i++) {
            if (maior<v[i]) {
                maior = v[i];
            }
        }
        return maior;
    }
    public static void imprimirVetor(int[] v) {
     for (int i = 0; i < v.length; i++) {
        System.out.print(v[i]+" ");
     }   
     System.out.println();
    }
    public static int[] lerv(int n){
        int[] v = new int[n];
        for (int i = 0; i < v.length; i++) {
            v[i] = (int) Math.floor(Math.random()*v.length);
        }
        return v;
    }
}

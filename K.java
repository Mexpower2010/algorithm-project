import java.util.*;

public class K {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in); 
        int t = S.nextInt();
        int n = S.nextInt(); 
        int[] v = new int[n];
        
        for (int i = 0; i < v.length; i++) {
            v[i] = S.nextInt();
        }
        
        int[] sortedV = v.clone();
        Arrays.sort(sortedV);
        
        int[] sufMax = new int[n + 1];
        sufMax[n] = t - sortedV[n - 1]; 
        
        for (int i = n - 1; i >= 1; i--) {
            int intervaloAtual = sortedV[i] - sortedV[i - 1] - 1;
            sufMax[i] = Math.max(intervaloAtual, sufMax[i + 1]);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < v.length; i++) {
            int idx = Arrays.binarySearch(sortedV, v[i]);
            
            sb.append(sufMax[idx + 1]).append(" ");
        }
        
        System.out.print(sb.toString());
    }

    public static void metodo(int t, int[]v) {
    }
}
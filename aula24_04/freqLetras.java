import java.util.Scanner;
public class freqLetras {
    final static public Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int freq[] = new int [128];
        for (int i = 0; i < S.nextInt(); i++) {

            StringBuilder sb = new StringBuilder();

            sb.append(S.nextLine());

            char[] tex = sb.toString().toLowerCase().toCharArray();

            int maior = Integer.MIN_VALUE;

            for (int j = 0; j < tex.length; j++) { 
                if((int)tex[i]!=0);
                freq[(int)tex[i]]++;

                if (freq[(int)tex[i]]>maior) {
                    maior = freq[(int)tex[i]];
                }
            }

            for (int j = 0; j < freq.length; j++) {
                
            }
            
        }
    
    }
}

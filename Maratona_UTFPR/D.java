package Maratona_UTFPR;

import java.util.*;
public class D{
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int a = S.nextInt();
        int b = S.nextInt();
        int[] vFA = new int[1000];
        int[] vFb = new int[1000];
        for (int i = 0; i < a; i++) {
            int temp = S.nextInt()-1;
            if(vFA[temp]==0){
                vFA[temp]=1;
            }else {
                vFA[temp]=2;
            }
        }
        for (int i = 0; i < b; i++) {
            int temp = S.nextInt()-1;
            if(vFb[temp]==0){
                vFb[temp]=1;
            }else {
                vFb[temp]=2;
            }
        }
        if (Arrays.equals(vFA, vFb)) {
            System.out.println(0);
        }else{
            int qtdtrocasA = 0;
            int qtdtrocasB = 0;
            for (int i = 0; i < 1000; i++) {
                if (vFA[i]!=vFb[i]) {  
                if (vFA[i]==2&&vFb[i]==0) {
                    qtdtrocasA++;
                }
                if (vFb[i]==2&& vFA[i] == 0) {
                    qtdtrocasB++;
                }}
            }
            int qtdtroca = Math.min(qtdtrocasA, qtdtrocasB);
            System.out.println(qtdtroca);
        }
    }
}

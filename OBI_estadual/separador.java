package OBI_estadual;
import java.util.Scanner;
import java.util.ArrayList;
public class separador {
    final static public Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int numProdutos = S.nextInt();
        int numFilas = S.nextInt();
        ArrayList<Integer> filas[]= new ArrayList[numFilas];
        for(int j = 0; j<numFilas; j++){
            filas[j] = new ArrayList<>();
        }
        int[] pesoFilas = new int[numFilas];
        int menorPesoFila = 0;
        for(int i = 0; i<numProdutos; i++){
            int pesoProduto = S.nextInt();
            for(int j = 0; j<numFilas; j++){
                if(pesoFilas[j]==menorPesoFila){
                    filas[j].add(pesoProduto);
                    pesoFilas[j]+=pesoProduto;
                    break;
                }
            }
            menorPesoFila = 10000;
            for(int j = 0; j<numFilas; j++){
                if(pesoFilas[j]<menorPesoFila){
                    menorPesoFila = pesoFilas[j];
                }
            }
        }
        for(int i = 0; i<numFilas; i++){
            for(int num : filas[i]){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
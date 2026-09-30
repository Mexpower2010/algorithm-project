package simulado08_05;
import java.util.Scanner;
public class ventilador {

    public static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] matrix = new int[S.nextInt()][S.nextInt()];
        int colunaB = S.nextInt();
        matrix = lerMatix(matrix);
        /*for (int i = 0; i < matrix.length; i++) {
                int identificarMov = indentificarMov(matrix, colunaB, i);
                if (identificarMov==Integer.MIN_VALUE) {
                    break;
                }
        }*/
    }
    public static int identificarMov(int[][]matrix, int colunaB, int l) {
        int identificarMov=0;
        for (int i = 0; i < matrix[l].length; i++) {
            if (matrix[l][i]!=0) {
                if (i>colunaB) {
                    identificarMov=identificarMov-matrix[l][i];
                }else if(i<colunaB){
                    identificarMov+=matrix[l][i];
                }else{
                    System.out.println("BOOM "+l+" "+i);
                    int a = Integer.MIN_VALUE;
                    return  a;
                }
            }
        }
        return identificarMov;
    }
    public static int[][] lerMatix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = S.nextInt();
            }
        }
        return matrix;
    }
}
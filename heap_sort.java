import java.util.Scanner;
public class heap_sort {
    public static void main(String[] args) {
        int[] vetor = new int[10];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) Math.floor(Math.random()*vetor.length);
        }
        
        int n = vetor.length;
        
        System.out.println("\nvetor desordenado: ");
        imprimirVetor(vetor);

        for (int i = n/2-1; i >= 0; i--) {
            aplicarHeap(vetor, n, i);
        }

        System.out.println("\nvetor quase ordenado: ");
        imprimirVetor(vetor);
        
        for (int i = n-1; i > 0; i--) {
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;
            aplicarHeap(vetor, i, 0);
        }
        
        System.out.println("\nvetor ordenado: ");
        imprimirVetor(vetor);
    }
    
    public static void aplicarHeap(int[] v, int n, int i) {
        int raiz = i;
        int esquerda = 2*i+1;
        int direita = 2*i+2; 
        
        if (esquerda < n && v[esquerda] > v[raiz]) {
            raiz = esquerda;
        }
        if (direita < n && v[direita] > v[raiz]) {
            raiz = direita;
        }
        if (raiz != i) {
            int temp = v[i];
            v[i] = v[raiz];
            v[raiz] = temp;
            aplicarHeap(v, n, raiz);
        }
    }
    
    public static void imprimirVetor(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }
}
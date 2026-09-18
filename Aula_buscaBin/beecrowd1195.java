package Aula_buscaBin;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

import OBI_estadual.separador;
import aula24_07.somarNuns;

class No{
    int valor;
    No direita;
    No esquerdo;
    No(int valor){
        this.valor = valor;
        this.direita = null;
        this.esquerdo = null;
    }
}

public class beecrowd1195 {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int n = S.nextInt();

        for (int i = 0; i < n; i++) {
            int qtdNo = S.nextInt();
            No raiz = new No(S.nextInt());
            for (int j = 0; j < qtdNo-1; j++) {
                raiz = montarArvore(raiz, S.nextInt());
            }
            imprimiPre(raiz);
        }
    }
    public static void imprimiPre(No raiz){
        
        Queue<Integer> filaQueue = new ArrayDeque<>();

        montarSoutPre(filaQueue, raiz);
        
        while (!filaQueue.isEmpty()) {
            System.out.print(filaQueue.poll()+" ");
        }
        System.out.println();
    }

    public static void montarSoutPre(Queue<Integer> filaQueue, No raiz){
        if (raiz.esquerdo!=null) {
            if (!filaQueue.contains(raiz.valor)) {
                filaQueue.add(raiz.valor);
            }
            montarSoutPre(filaQueue, raiz.esquerdo);
        }else if(raiz.direita!=null){
            if (!filaQueue.contains(raiz.valor)) {
                filaQueue.add(raiz.valor);
            }
            montarSoutPre(filaQueue, raiz.direita);
        }
    }

    public static No montarArvore(No atual, int valor) {
        if (atual==null) {
            return new No(valor);
        }
        if (valor>atual.valor) {
            atual.direita = montarArvore(atual.direita,valor); 
        }else{
            atual.esquerdo = montarArvore(atual.esquerdo, valor);
        }
        return atual;
    }
}

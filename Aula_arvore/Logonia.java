package Aula_arvore;
import java.util.LinkedList;
import java.util.Queue;

class No {
    int valor;
    No esquerda;
    No direita;

    No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}

class ArvoreBinariaBusca {
    No raiz;

    void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    No inserirRecursivo(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRecursivo(atual.direita, valor);
        }

        return atual;
    }

    boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    boolean buscarRecursivo(No atual, int valor) {
        if (atual == null) {
            return false;
        }

        if (valor == atual.valor) {
            return true;
        }

        if (valor < atual.valor) {
            return buscarRecursivo(atual.esquerda, valor);
        } else {
            return buscarRecursivo(atual.direita, valor);
        }
    }

    void preOrdem() {
        preOrdemRecursivo(raiz);
        System.out.println();
    }

    void preOrdemRecursivo(No atual) {
        if (atual == null) return;
        System.out.print(atual.valor + " ");
        preOrdemRecursivo(atual.esquerda);
        preOrdemRecursivo(atual.direita);
    }

    void emOrdem() {
        emOrdemRecursivo(raiz);
        System.out.println();
    }

    void emOrdemRecursivo(No atual) {
        if (atual == null) return;
        emOrdemRecursivo(atual.esquerda);
        System.out.print(atual.valor + " ");
        emOrdemRecursivo(atual.direita);
    }

    void posOrdem() {
        posOrdemRecursivo(raiz);
        System.out.println();
    }

    void posOrdemRecursivo(No atual) {
        if (atual == null) return;
        posOrdemRecursivo(atual.esquerda);
        posOrdemRecursivo(atual.direita);
        System.out.print(atual.valor + " ");
    }

    void largura() {
        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.print(atual.valor + " ");

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }

        System.out.println();
    }
}

public class Logonia {
    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        int[] valores = {8, 3, 10, 1, 6, 14};
        for (int v : valores) {
            arvore.inserir(v);
        }

        System.out.println("Pre-ordem:");
        arvore.preOrdem();

        System.out.println("Em ordem:");
        arvore.emOrdem();

        System.out.println("Pos-ordem:");
        arvore.posOrdem();

        System.out.println("Largura:");
        arvore.largura();

        System.out.println("Busca 6: " + arvore.buscar(6));
        System.out.println("Busca 7: " + arvore.buscar(7));
    }
}
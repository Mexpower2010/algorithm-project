package Aula_arvore;
import java.util.ArrayList;
import java.util.List;

class NoGeral {
    int valor;
    List<NoGeral> filhos;

    NoGeral(int valor) {
        this.valor = valor;
        this.filhos = new ArrayList<>();
    }
}

public class Main_Arvore {
    static void adicionarFilho(NoGeral pai, NoGeral filho) {
        pai.filhos.add(filho);
    }

    static void imprimirFilhos(NoGeral no) {
        System.out.print(no.valor + " -> ");

        for (NoGeral filho : no.filhos) {
            System.out.print(filho.valor + " ");
        }

        System.out.println();

        for (NoGeral filho : no.filhos) {
            imprimirFilhos(filho);
        }
    }

    static void imprimirFolhas(NoGeral no) {
        if (no.filhos.isEmpty()) {
            System.out.print(no.valor + " ");
            return;
        }

        for (NoGeral filho : no.filhos) {
            imprimirFolhas(filho);
        }
    }

    public static void main(String[] args) {
        NoGeral raiz = new NoGeral(1);
        NoGeral n2 = new NoGeral(2);
        NoGeral n3 = new NoGeral(3);
        NoGeral n4 = new NoGeral(4);
        NoGeral n5 = new NoGeral(5);
        NoGeral n6 = new NoGeral(20);

        adicionarFilho(raiz, n2);
        adicionarFilho(raiz, n3);
        adicionarFilho(n2, n4);
        adicionarFilho(n2, n5);
        adicionarFilho(n4, n6);

        System.out.println("Filhos de cada nó:");
        imprimirFilhos(raiz);

        System.out.print("Folhas: ");
        imprimirFolhas(raiz);
    }
}
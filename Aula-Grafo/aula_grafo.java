import java.util.Scanner;
public class aula_grafo {
    final static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        /*  grafo -- estrutura que usa arvore(mas n é) pra organizar dados 

                    TEM MUITOS TIPOS DE GRAFOS e muitos sao o capeta
                    a gente ve pra OBI os NAO DIRECIONADOS

            imagine que sao varios pontos (vertices) ligados por linhas (arestas) 
            e ao contrario da arvore, o grafo pode ter ciclos e ter mais de 2 linhas (ou seja, vc pode voltar pro mesmo ponto)
            a gente pode representar o grafo de varias formas
            mas a mais comum é a matriz de adjacencia(matiz) (ou seja, uma matriz que mostra se os vertices estao ligados ou nao)
            a lista (arraylist/linkedlist) de adjacencia (ou seja, uma lista que mostra quais vertices estao ligados a cada vertice)
            e a lista(arraylist/linkedlist) de arestas (ou seja, uma lista que mostra quais vertices estao ligados por cada aresta(linha))
            
            
        */
        while (true) {
            System.out.println("1- Digite a quantidade de vertices do grafo(matriz adjacencia): ");
            System.out.println("2- Digite a quantidade de vertices do grafo(lista adjacencia): ");
            System.out.println("3- Digite a quantidade de arestas do grafo(lista de arestas): ");
            switch (s.nextInt()) {
                case 1:
                    int qtdVertice = s.nextInt();
                    int [][] matriz = new int[qtdVertice][qtdVertice];
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[i].length; j++) {
                            matriz[i][j] = s.nextInt();
                        }
                    }
                    break;
                case 2:
                    // Process list adjacency
                    break;
                case 3:
                    // Process edge list
                    break;
                default:
                    break;
            }
            
        }
        
        

    }
}

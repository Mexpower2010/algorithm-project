import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class estrutura {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        while (S.hasNext()) {
            int qtdOp= S.nextInt();
            boolean fila ;
            boolean filaPioridade ;
            boolean Pilha ;
            boolean notS;
            ArrayList<Integer> lista1 = new ArrayList<>();
            ArrayList<Integer> lista2 = new ArrayList<>();
            Integer primeiro=0;
            Integer ultimo=0;
            Integer maior = Integer.MIN_VALUE;
            for (int i = 0; i <qtdOp; i++) {
                int op = S.nextInt();
                int num = S.nextInt();
                if (op==1) {
                    lista1.add(num);
                }else{
                    lista2.add(num);
                }
                if (num>maior) {
                    maior = num;
                }
                if (i==0) {
                    primeiro = num;
                }
                if (i==qtdOp-1) {
                    ultimo=num;
                }
            }
            for (Integer num : lista2) {
                if(num == ultimo){
                    Pilha = true;
                }
            }
        }
    }
}

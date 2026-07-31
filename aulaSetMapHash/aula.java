package aulaSetMapHash;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

import aula24_07.somarNuns;

public class aula {
    public final static Scanner S = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        HASSHING -->  ideia de tornar uma chave(num) em uma posição de armazenamento
        */
        /*int x = S.nextInt();
        LinkedList<Integer>[] vetorHash = new LinkedList[13];
        vetorHash[HASSHING(x)].add(x);*/


        /*HashSet<String> nomes = new HashSet<>();
        nomes.add("penis");
        nomes.add("penis");
        if (nomes.contains("penis")) {
            System.out.println("Encontrado");            
        }else{
            System.out.println("nao encontrado");
        }*/

        /*TreeSet<Integer> numeros = new TreeSet<>();

        numeros.add(1);
        numeros.add(2);
        numeros.add(-1);
        numeros.add(300);
        for (Integer i : numeros) {
            System.out.println(i);
        }*/

        /*HashMap<String, Integer> estoque = new HashMap<>();
        estoque.put("Oleo de bebe", 67);
        estoque.put("P.didrry", 69);
        estoque.put("Fita Isolante", 24);

        System.out.println(estoque.get("Oleo de bebe"));
        System.out.println(estoque.containsKey("P.didrry"));*/
        
        TreeMap<String, Integer> notas = new TreeMap<>();
        notas.put("b", 80);
        notas.put("a", 56);
        notas.put("Carlos", 14);//carlos 14

        for (String string : notas.keySet()) {
            System.out.println(string + " " + notas.get(string));
        }
    }
    public static int HASSHING(int x){
        x = x%13;
        return x;
    }
}

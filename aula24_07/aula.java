package aula24_07;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class aula {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        StringBuilder Ape = new StringBuilder();
        //regex --> uma sequencia de caracteres q descreve um padrao de busca
        //
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String email1 = "xibiu@penis.vibrador";
        //System.out.println(Pattern.matches(regex, email1));
        
        String txt = "Ana fez 15 pontos, Bia fez 9 e Caio fez 27.";

        Pattern padrao = Pattern.compile("\\d+");
        Matcher buscador = padrao.matcher(txt);

        while (buscador.find()) {
            System.out.println("Num encontrado: "+ buscador.group());
        }
    }
  
}

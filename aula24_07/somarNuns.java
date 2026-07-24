package aula24_07;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class somarNuns {
    final static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        String l = s.nextLine();
        Pattern padrao = Pattern.compile("\\d+");
        Matcher m = padrao.matcher(l);
        int soma = 0;
        while (m.find()) {
            soma+=Integer.parseInt(m.group());
        }
        System.out.println(soma);
    }
}

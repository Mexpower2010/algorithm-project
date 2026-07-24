package aula24_07;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class placas {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        String placa = S.nextLine();

        Pattern p1 = Pattern.compile("^[A-Z]{3}-[\\d]{4}");
        Pattern p2 = Pattern.compile("^[A-Z]{3}\\d[A-Z][\\d]{2}");

        Matcher m1 = p1.matcher(placa);
        Matcher m2 = p2.matcher(placa);

        if (m1.find()) {
            System.out.println("1");
        }else if (m2.find()) {
            System.out.println("2");
        }else{
            System.out.println("0");
        }
    }
}

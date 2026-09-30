package simulado08_05;
import java.util.Scanner;
public class suicidio{
    final public static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int n = S.nextInt();
        for (int index = 0; index < n; index++) {
            int qtdCabloco = S.nextInt();
            int pulo = S.nextInt();
            int ultimoMolestado = 0;
            for (int i = 1; i <= qtdCabloco; i++) {
                ultimoMolestado = (ultimoMolestado+pulo)%i;
            }
            System.out.println("Case "+(index+1)+": "+(ultimoMolestado+1));
        }
    }
}
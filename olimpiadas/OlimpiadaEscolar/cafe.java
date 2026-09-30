package olimpiadas.OlimpiadaEscolar;
import java.util.Scanner;
public class cafe{
    final static Scanner S = new Scanner(System.in); 
    public static void main(String[] args) {
        int qtdPessoa = S.nextInt();
        int qtdLitrosPorVez = S.nextInt()*1000;
        int qtdCafePessoa = S.nextInt();
        int qtdLitrosMin = qtdCafePessoa*qtdPessoa;
        if (qtdLitrosMin%qtdLitrosPorVez==0) {
            System.out.println(qtdLitrosMin/1000);
        }else{ 
        qtdLitrosMin = qtdLitrosPorVez-(qtdLitrosMin%qtdLitrosPorVez)+qtdLitrosMin;
            System.out.println(qtdLitrosMin/1000);
        }
    }
}
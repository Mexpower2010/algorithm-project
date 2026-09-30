import java.util.Scanner;
public class parenteses {
    final static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        while (S.hasNext()) {
            int qtdParenteses = 0;
            int i = 0;
            char[] expressao = S.next().trim().toCharArray();
            do {
                if (expressao[i]=='(') {
                    qtdParenteses++;
                }
                if (expressao[i]==')') {
                    qtdParenteses--;
                }
                i++;
            } while (qtdParenteses>=0&&i<expressao.length);
            if (qtdParenteses==0) {
                System.out.println("correct");
            }else{
                System.out.println("incorrect");
            }
        }
    }
}

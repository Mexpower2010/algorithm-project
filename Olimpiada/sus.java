import java.util.Scanner;
import java.time.LocalTime;
public class sus {
    final static  Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        while (S.hasNext()) {

            int num = S.nextInt();
            LocalTime [] tempos = new LocalTime[num];
            int[] minsDeath = new int[num];
            int qtdDeaths = 0;
            LocalTime proximoAtendimento = LocalTime.of(7, 30);

            for (int i = 0; i < num; i++) {
                tempos[i] = LocalTime.of(S.nextInt(), S.nextInt());
                minsDeath[i] = S.nextInt();
                if (i!=0) {
                    if (tempos[i-1].plusMinutes(30).isBefore(tempos[i].plusMinutes(minsDeath[i]))) {
                        qtdDeaths++;
                    }
                }
            }
            System.out.println(qtdDeaths);
        }
    }
}


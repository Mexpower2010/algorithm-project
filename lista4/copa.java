package lista4;
import java.util.*;
public class copa {
    public static Scanner S = new Scanner(System.in);
    public static void main(String[] args) {
        int mestre1 = S.nextInt();
        int mestre2 = S.nextInt();
        if(mestre2>8&&mestre1<=8||mestre2<=8&&mestre1>8){
            System.out.println("final");
        }else{ 
        if(mestre1-mestre2==1){
            if (mestre1%2==1) {
                System.out.println("oitavas");
            }else{
                System.out.println("quartas");
            }
        }else{
            System.out.println("semifinal");
        }
        }
    }
}

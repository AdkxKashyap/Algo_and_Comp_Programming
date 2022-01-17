package Main;
import java.util.Scanner;

public class pattern9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int lstar=1;
        int rstar=n;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=rstar;j++){
                if(j==lstar)System.out.print("*\t");
                else if(j==rstar)System.out.print("*\t");
                else{
                    System.out.print("\t");
                }
            }
            
            if(i<=n/2){
                lstar++;
                rstar--;
            }
            else{
                lstar--;
                rstar++;
            }
            System.out.println();
        }
    }
}

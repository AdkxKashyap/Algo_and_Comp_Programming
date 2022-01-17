package Main;
import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int nst=n;
        int nsp=0;//for spaces
        for(int i=1;i<=n;i++){
            //for spaces
            for(int space=1;space<=nsp;space++)System.out.print("\t");
            //for stars
            for(int stars=1;stars<=nst;stars++)System.out.print("*\t");

            nsp++;
            nst--;
            System.out.println();
        }
    }
}

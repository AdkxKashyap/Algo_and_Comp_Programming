package Main;
import java.util.Scanner;

public class Pattern7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int nsp=0;
        for(int i=1;i<=n;i++){
            for(int space=1;space<=nsp;space++)System.out.print("\t");
            System.out.print("*\t");
            nsp++;
            System.out.println();
        }
    }
}

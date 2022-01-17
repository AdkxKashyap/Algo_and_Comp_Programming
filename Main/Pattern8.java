package Main;
import java.util.Scanner;
//same as 7
public class Pattern8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int nsp=n;
        for(int i=1;i<=n;i++){
            for(int space=1;space<nsp;space++)System.out.print("\t");
            System.out.print("*\t");
            nsp--;
            System.out.println();
        }
    }
}

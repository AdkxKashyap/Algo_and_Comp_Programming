package Main;
import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int nst=n/2+1;
        int nsp=1;

        for(int i=1;i<=n;i++){
            //print stars
            //print space
            //print stars
            for(int star=1;star<=nst;star++)System.out.print("*\t");
            for(int space=1;space<=nsp;space++)System.out.print("\t");
            for(int star=1;star<=nst;star++)System.out.print("*\t");

            if(i<=n/2){
                nst--;
                nsp+=2;
            }
            else{
                nst++;
                nsp-=2;
            }
            System.out.println();
        }
    }
}

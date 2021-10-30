import java.util.Scanner;

public class Pattern5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int nst=1;
        int nsp=n/2;
        for(int i=1;i<=n;i++){
            for(int space=1;space<=nsp;space++)System.out.print("\t");
            for(int stars=1;stars<=nst;stars++)System.out.print("*\t");

            if(i<=n/2){
                nst+=2;
                nsp-=1;
            }
            else{
                nst-=2;
                nsp+=1;
            }
            System.out.println();
        }
    }
}

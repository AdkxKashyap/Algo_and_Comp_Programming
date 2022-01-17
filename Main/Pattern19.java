package Main;
import java.util.Scanner;

public class Pattern19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(r==0 && c<=n/2)System.out.print("*\t");
                else if(c==n/2)System.out.print("*\t");
                else if(r==n/2)System.out.print("*\t");
                else if(c==n-1 && r<=n/2)System.out.print("*\t");
                else if(r==n-1 && c>=n/2)System.out.print("*\t");
                else if(c==0 && r>=n/2)System.out.print("*\t");
                else System.out.print("\t");
            }
            System.out.println();
        }
    }
}

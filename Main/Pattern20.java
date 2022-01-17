package Main;
import java.util.Scanner;

public class Pattern20 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(c==0 || (c+r==n-1 && r>=n/2) || (c-r==0 && r>=n/2) || c==n-1){
                    System.out.print("*\t");
                }
                else System.out.print("\t");
            }
            
            System.out.println();
        }
    }
}

package Main;
import java.util.Scanner;
public class Pattern18 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n=in.nextInt();
            for(int r=0;r<n;r++){
                for(int c=0;c<n;c++){
                    if(r<=n/2){
                        if(r==0 || r==c || r+c==n-1)System.out.print("*\t");
                        else System.out.print("\t");
                    }
                    else{
                        if(r+c>=n-1 && c<=r)System.out.print("*\t");
                        else System.out.print("\t");
                    }
                }
                System.out.println();
            }
        }
    }

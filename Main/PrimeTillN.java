package Main;
import java.util.Scanner;

public class PrimeTillN {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=2;i<=n;i++){
            for(int j=2;j<=i/2;j++){
                if(i%j==0){
                    System.out.print(i+" ");
                    break;
                }
            }
        }
    }
}

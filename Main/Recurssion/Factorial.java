package Main.Recurssion;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int res=factorial(n);
        System.out.println(res);
    }

    public static int factorial(int n){
        if(n==1)return 1;
        int res=n*factorial(n-1);
        return res;
    }
}

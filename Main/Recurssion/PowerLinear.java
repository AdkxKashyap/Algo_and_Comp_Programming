package Main.Recurssion;
import java.util.Scanner;

public class PowerLinear {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        int n=scanner.nextInt();
        int res=power(x,n);
        System.out.println(res);
    }

    public static int power(int x,int n){
        if(n==1)return x;
        int res=x*power(x,n-1);
        return res;
    }
}

import java.util.Scanner;

public class AnyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int  destBase= scn.nextInt();
        int decimal=anybaseToDecimal(n, sourceBase);
        int res=decimalToAnybase(decimal, destBase);
        System.out.println(res);
     }
     
     public static int anybaseToDecimal(int n, int b){
        // write your code here
        int decimal=0;
        int pow=0;
        while(n>0){
            int rem=n%10;
            int quo=n/10;
            decimal+=rem*Math.pow(b, pow++);
            n=quo;
        }
        return decimal;
     }

     public static int decimalToAnybase(int n, int b){
        
        // write code here
       int ans=0;
       int pow=1;
       while(n>0){
           int rem=n%b;
           int quo=n/b;
           ans+=rem*pow;
           pow*=10;
           n=quo;
       }
       return ans;
    }
}

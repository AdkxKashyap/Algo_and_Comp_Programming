import java.util.Scanner;

public class AnyBaseMultiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
    
        int d = getProduct(b, n1, n2);
        System.out.println(d);
     }
    
     public static int getProduct(int b, int n1, int n2){
         // write your code here
         int zeroes=0;
         int res=0;
         while(n2>0){
             int pow=0;
             int tmpRes=0;
             int carry=0;
             int tmpN=n1;
             int val2=n2%10;
             n2/=10;
             while(tmpN!=0 || carry!=0){
                 int val1=tmpN%10;
                 tmpN/=10;
                 
                 int mult=val1 * val2 +carry;
                 carry=mult/b;
                 tmpRes+=mult%b*Math.pow(10,pow++);
             }
             tmpRes*=Math.pow(10, zeroes++);
             res=getSum(b, res,tmpRes);
         }
         return res;
     }
     public static int getSum(int b, int n1, int n2){
        // write ur code here
        int pow=0;
        int res=0;
        int carry=0;
        while(n1!=0 || n2!=0 || carry!=0){
           int val1=n1%10;
           n1/=10;
           int val2=n2%10;
           n2/=10;
           int sum=val1+val2+carry;
           res+=sum%b*Math.pow(10, pow++);
           carry=sum/b;
        }
        return res;
    }
}

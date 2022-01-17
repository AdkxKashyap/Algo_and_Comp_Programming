import java.util.Scanner;

public class AnybaseAddition {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
    
        int d = getSum(b, n1, n2);
        System.out.println(d);
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

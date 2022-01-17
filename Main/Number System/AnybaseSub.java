import java.util.Scanner;

public class AnybaseSub {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
    
        int d = getDifference(b, n1, n2);
        System.out.println(d);
     }
    
     public static int getDifference(int b, int n1, int n2){
         // write your code here
         int pow=0;
         int carry=0;
         int res=0;

         while(n2!=0){
            int val1=n1%10;
            n1/=10;
            int val2=n2%10;
            n2/=10;
            int sub=val2-carry-val1;
            if(sub<0){
                sub+=b;
                carry=1;
            }
            else carry=0;
            res+=sub%b*Math.pow(10, pow++);
         }
         return res;
     }
}

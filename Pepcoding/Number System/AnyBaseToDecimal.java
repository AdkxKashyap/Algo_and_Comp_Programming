import java.util.*;

public class AnyBaseToDecimal {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int d = getValueIndecimal(n, b);
        System.out.println(d);
     }
    
     public static int getValueIndecimal(int n, int b){
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
    }

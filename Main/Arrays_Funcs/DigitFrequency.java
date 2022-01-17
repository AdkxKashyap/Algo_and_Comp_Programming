package Main.Arrays_Funcs;

import java.util.Scanner;

public class DigitFrequency {
    
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int d=scanner.nextInt();
        int count=0;
        while(n!=0){
            int q=n%10;
            n=n/10;
            if(q==d)count++;
        }
        System.out.println(count);
    }
}

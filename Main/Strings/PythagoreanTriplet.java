package Main.Strings;

import java.util.Scanner;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int c=scanner.nextInt();

        if(a>c){
            a=a+c;
            c=a-c;
            a=a-c;
        }
        if(b>c){
            b=b+c;
            c=b-c;
            b=b-c;
        }
        if(a*a+b*b==c*c){
            System.out.println(true);
        }
        else System.out.println(false);
    }
}

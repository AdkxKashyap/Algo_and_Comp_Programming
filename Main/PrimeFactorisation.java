package Main;
import java.util.Scanner;

public class PrimeFactorisation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=2;i*i<=n;i++){
            while(n%i==0){
                System.out.println(i+" ");
                n=n/i;
            }
        }
        //if n comes out prime
        if(n!=1)System.out.println(n);
    }
}

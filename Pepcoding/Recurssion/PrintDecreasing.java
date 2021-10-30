import java.util.Scanner;

public class PrintDecreasing {
    public static void main(String[] args) throws Exception {

        // write your code here
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        printDecreasing(n);
    }

    public static void printDecreasing(int n){
        if(n<1)return;
        printDecreasing(n-1);
        System.out.println(n);
    }
}

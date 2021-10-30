import java.util.Scanner;

public class ReverseANumber {
    public static void main(String[] args) {
   
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int tmp=n;
        while(tmp!=0){
            System.out.println(tmp%10);
            tmp=tmp/10;
        }
    }
}

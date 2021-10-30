import java.util.Scanner;

public class fibonnaci {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a=0,b=1;
        System.out.println(a);
        System.out.println(b);
        for(int i=2;i<n;i++){
            int tmp=a;
            System.out.println(a+b);
            a=b;
            b=tmp+b;
        }
    }
}

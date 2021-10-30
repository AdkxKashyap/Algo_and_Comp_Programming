import java.util.Scanner;
//**IMP
public class Pattern12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a=0,b=1,c=a+b;
        // System.out.println(a);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(a+"\t");
                int tmp=a;
                a=b;
                b=c;
                c=a+b;
            }
            System.out.println();
        }
    }
}

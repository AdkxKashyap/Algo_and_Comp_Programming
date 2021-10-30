import java.util.Scanner;

public class Pattern1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int nst=1;//number of stars,important for complex problems,follow structure
        for(int i=1;i<=n;i++){//row
            for(int j=1;j<=nst;j++)System.out.print("*\t");//stars

            nst++;
            System.out.println("");
        }
    }
}

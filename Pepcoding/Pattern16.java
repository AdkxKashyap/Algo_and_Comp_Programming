import java.util.Scanner;
//**IMP
//USE AP
public class Pattern16 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();

        int spaces=(2*n)-3;
        int stars=1;

        for(int i=1;i<=n;i++){
            //star
            int val=1;
            for(int star=1;star<=stars;star++){
                System.out.print(val++ + "\t");
            }
            for(int space=1;space<=spaces;space++){
                System.out.print("\t");
            }
            if(i==n)
            {
                stars--;
                val--;
            }
            for(int star=1;star<=stars;star++){
                System.out.print(--val +"\t");
            }
            spaces-=2;
            stars++;
            System.out.println();
        }
    }
}

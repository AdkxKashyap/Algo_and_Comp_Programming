package Main;
import java.util.Scanner;

public class Pattern17 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int spaces=n/2;
        int stars=1;
        
        for(int i=1;i<=n;i++){
            //spaces
            if(i==(n/2)+1){
                for(int space=1;space<=spaces;space++){
                    System.out.print("*\t");
                }
            }
            else{
                for(int space=1;space<=spaces;space++){
                    System.out.print("\t");
                }
            }
            //star
            for(int star=1;star<=stars;star++){
                System.out.print("*\t");
            }
            if(i<=n/2){
                stars++;
            }
            else stars--;

            System.out.println();
        }
    }
}

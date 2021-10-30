import java.util.Scanner;

public class Pattern10 {

     //** Using Linear Programming*/

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int row=n;
        n--;
        for(int r=0;r<row;r++){
            for(int c=0;c<row;c++){
               if(r+c==n/2 || c-r==n/2 || r+c==3*n/2  || r-c==n/2){
                   System.out.print("*\t");
               }
               else{
                   System.out.print("\t");
               }
            }
            System.out.println();
        }
    }

    // public static void main(String[] args) {
    //     Scanner sc=new Scanner(System.in);
    //     int n=sc.nextInt();
    //     int lStar=n/2+1;
    //     int rStar=n/2+1;
    //     for(int r=1;r<=n;r++){
    //         for(int c=1;c<=n;c++){
    //             if(c==lStar)System.out.print("*\t");
    //             else if(c==rStar)System.out.print("*\t");
    //             else{
    //                 System.out.print("\t");
    //             }
    //         }
    //         if(r<=n/2){
    //             lStar--;
    //             rStar++;
    //         }
    //         else{
    //             lStar++;
    //             rStar--;
    //         }
    //         System.out.println();
    //     }
    // }
}

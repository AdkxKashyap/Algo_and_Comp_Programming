import java.util.Scanner;

public class Pattern15 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int spaces=(n/2);
        int var1=1;
        int var2=1;

        for(int i=1;i<=n;i++){
            for(int space=1;space<=spaces;space++){
                System.out.print("\t");
            }
            int tmp=var2;
            int col=spaces+1;
            for(int star=1;star<=var1;star++){
                
                System.out.print(tmp+"\t");
                
                if(col<=n/2)tmp++;
                else{
                    tmp--;
                }
                col++;
            }
            if(i<=n/2){
                var1+=2;
                var2++;
                spaces--;
            }
            else {
                var1-=2;
                var2--;
                spaces++;
            }
            
            System.out.println();
        }
    }
}

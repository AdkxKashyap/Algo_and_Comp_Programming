package Arrays_Funcs;

import java.util.Scanner;

public class Subsets {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=scanner.nextInt();
        int limit=(int)Math.pow(2, n);

        for(int i=0;i<limit;i++){
            StringBuilder fstr=new StringBuilder();
            int num=i;
            for(int j=n-1;j>=0;j--){
                StringBuilder str=new StringBuilder();
                int r=num%2;
                num=num/2;
                str= r==0 ? str.append("-\t"): str.append(arr[j]+"\t");
                fstr=str.append(fstr);
            }
            System.out.println(fstr);
        }
    }
}

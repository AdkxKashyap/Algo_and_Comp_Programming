package Main.Arrays_Funcs;

import java.util.Scanner;

public class SumTwoArrays {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n1=scan.nextInt();
        int[] a1=new int[n1];
        for (int i=0;i<n1;i++){
            a1[i]=scan.nextInt();
        }
        int n2=scan.nextInt();
        int[] a2=new int[n2];
        for(int i=0;i<n2;i++){
            a2[i]=scan.nextInt();
        }
        int rsize=Math.max(a1.length,a2.length)+1;
        int[] res=new int[rsize];
        int i=n1-1;
        int j=n2-1;
        int carry=0;
        for(int k=rsize-1;k>=0;k--){
            int val1=i>=0?a1[i]:0;
            int val2=j>=0?a2[j]:0;
            int sum=val1+val2+carry;
            res[k]=sum%10;
            carry=sum/10;
            i--;
            j--;
        }
        if(res[0]!=0)System.out.println(res[0]);
        for(int l=1;l<rsize;l++){
            System.out.println(res[l]);
        }
    }
    
    
}

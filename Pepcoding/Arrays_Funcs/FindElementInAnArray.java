package Arrays_Funcs;

import java.util.Scanner;

public class FindElementInAnArray {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int d=scanner.nextInt();
        int i;
        for(i=0;i<n;i++){
            if(arr[i]==d){
                System.out.println(i);
                break;
            }
        }
        if(i==n)System.out.println(-1);
        
    }
}

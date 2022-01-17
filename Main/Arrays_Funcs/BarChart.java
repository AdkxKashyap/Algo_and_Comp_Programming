package Main.Arrays_Funcs;

import java.util.Scanner;

public class BarChart {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int maxHeight=arr[0];
        for(int i=1;i<n;i++){
            maxHeight=Math.max(arr[i], maxHeight);
        }
        for(int height=maxHeight;height>0;height--){
            for(int row=0;row<n;row++){
                if(arr[row]>=height)System.out.print("*\t");
                else System.out.print("\t");
            }
            System.out.println();
        }
    }
}

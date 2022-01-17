package Main.Arrays_Funcs;

import java.util.Scanner;

public class ReverseArray {
    static Scanner scanner = new Scanner(System.in);

    public static void takeInput(int[]arr,int n){
        for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
        }
    }
    public static void main(String[] args) {
        int n1=scanner.nextInt();
        int[] a1=new int[n1];
        takeInput(a1,n1);


        reverse(a1,n1);
        display(a1);
    }
    public static void display(int[] arr){
        for(int i:arr)System.out.print(i+" ");
    }

    static void reverse(int[] arr,int n){
        int l=0,r=n-1;
        while(l<r){
            arr[l]=arr[l]+arr[r];
            arr[r]=arr[l]-arr[r];
            arr[l]=arr[l]-arr[r];
            l++;
            r--;
        }
    }
}

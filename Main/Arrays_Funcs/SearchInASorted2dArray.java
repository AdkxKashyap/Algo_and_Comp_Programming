package Main.Arrays_Funcs;

import java.util.Scanner;

public class SearchInASorted2dArray {
    static Scanner scanner = new Scanner(System.in);

    public static void takeInput(int[][]arr,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                arr[i][j]=scanner.nextInt();
        }
    }

    public static void main(String[] args) {
        int n=scanner.nextInt();
        int[][] arr=new int[n][n];
        takeInput(arr,n,n);
        int data=scanner.nextInt();
        find(arr, n,data);
    }
    public static void find(int[][] arr,int n,int data){
        int r=0,c=n-1;
        while(r<n && c>=0){
            if(data==arr[r][c]){
                System.out.println(r);
                System.out.println(c);
                return;
            }
            if(data>arr[r][c]){
                r++;
            }
            if(data<arr[r][c]){
                c--;
            }
        }
        System.out.println("Not Found");
    }

}

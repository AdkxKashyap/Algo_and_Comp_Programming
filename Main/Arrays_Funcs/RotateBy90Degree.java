package Main.Arrays_Funcs;

import java.util.Scanner;

public class RotateBy90Degree {
    static Scanner scanner = new Scanner(System.in);

    public static void takeInput(int[][] arr,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
    }
    public static void main(String[] args) {
        int n=scanner.nextInt();
        int[][] arr=new int[n][n];
        takeInput(arr, n, n);
        rotate(arr);
    }

    public static void rotate(int[][] arr){
        for(int col=0;col<arr[0].length;col++){
            for(int row=arr.length-1;row>=0;row--){
                System.out.print(arr[row][col]);
            }
            System.out.println();
        }
    }
}

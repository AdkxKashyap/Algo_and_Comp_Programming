package Arrays_Funcs;

import java.util.Scanner;

public class StateOfWakanda_2 {
    static Scanner scanner = new Scanner(System.in);

    public static void takeInput(int[][] arr,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
    }

    public static void printPath(int[][] arr){
        
        for(int diagonal=0;diagonal<arr[0].length;diagonal++){
            int col=diagonal;
            for(int row=0;row<(arr.length-diagonal);row++){
                System.out.println(arr[row][col]);
                col++;
            }
        }
    }
    public static void main(String[] args) {
        int n=scanner.nextInt();
        int[][] arr=new int[n][n];
        takeInput(arr, n, n);
        printPath(arr);
    }
}


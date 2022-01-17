package Arrays_Funcs;

import java.util.Scanner;

public class StateOfWakanda_1 {
    static Scanner scanner = new Scanner(System.in);

    public static void takeInput(int[][] arr,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
    }

    public static void printPath(int[][] arr){
        for(int j=0;j<arr[0].length;j++){
            if(j%2==0){
                for(int i=0;i<arr.length;i++){
                    System.out.println(arr[i][j]);
                }
            }
            else{
                for(int i=arr.length-1;i>=0;i--){
                    System.out.println(arr[i][j]);
                }
            }
        }
    }
    public static void main(String[] args) {
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] arr=new int[n][m];
        takeInput(arr, n, m);
        printPath(arr);
    }
}

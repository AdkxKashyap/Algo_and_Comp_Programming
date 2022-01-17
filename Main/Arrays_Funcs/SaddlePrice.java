package Main.Arrays_Funcs;

import java.util.Scanner;

public class SaddlePrice {
    static Scanner scanner = new Scanner(System.in);

    public static void takeInput(int[][]arr,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                arr[i][j]=scanner.nextInt();
        }
    }
    public static void main(String[] args) {
        int n=scanner.nextInt();
        int[][] a1=new int[n][n];
        takeInput(a1,n,n);
        int res=findPoint(a1, n);
        if(res==-1)System.out.println("Invalid input");//condition might be wrong
        else System.out.println(res);
    }
    private static int findPoint(int[][] a1, int n) {
        //find min in each row.
        //use the col{j} to find max in jth col
        int i=0;
        
        while(i<n){
            int min=Integer.MAX_VALUE;
            int minJ=0;
            for(int j=0;j<n;j++){
                if(a1[i][j]<min){
                    min=a1[i][j];
                    minJ=j;
                }
            }
            int max=Integer.MIN_VALUE;
            int maxI=0;
            for(int row=0;row<n;row++){
                if(a1[row][minJ]>max){
                    maxI=row;
                    max=a1[row][maxI];
                }
            }
            if(maxI==i){
                return a1[maxI][minJ];
            }
            i++;
        }
        return -1;
        
    }
}

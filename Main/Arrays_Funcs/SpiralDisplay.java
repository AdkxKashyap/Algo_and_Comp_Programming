package Main.Arrays_Funcs;

import java.util.Scanner;

public class SpiralDisplay {
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
        int m=scanner.nextInt();
        int[][] arr=new int[n][m];
        takeInput(arr, n, m);
        printPath(arr,n,m);
    }

    public static void printPath(int[][] arr,int n,int m){
        int minr=0;
        int minc=0;
        int maxc=arr[0].length;
        int maxr=arr.length;
        int count=0;
        //print 1st col of cell
        while(count<n*m){
            for(int i=minr;i<maxr;i++){
                System.out.println(arr[i][minc]);
                count++;
            }
            minc++;//increment here not end to avoid duplicates
            //print last row of cell
            for(int i=minc;i<maxc;i++){
                System.out.println(arr[maxr-1][i]);
                count++;
            }
            maxr--;
            //print last col of cell
            for(int i=maxr-1;i>=minr;i--){
                System.out.println(arr[i][maxc-1]);
                count++;
            }
            maxc--;
            //print 1s row  of cell
            for(int i=maxc-1;i>=minc;i--){
                System.out.println(arr[minr][i]);
                count++;
            }
            minr++;
        }
        
    }
}

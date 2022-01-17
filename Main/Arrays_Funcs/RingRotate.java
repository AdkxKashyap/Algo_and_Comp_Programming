package Main.Arrays_Funcs;

import java.util.Scanner;

//Do spiral display first
public class RingRotate {
    static Scanner scanner = new Scanner(System.in);

    public static void takeInput(int[][] arr,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
    }
    public static int[] extract1DArr(int[][] arr,int n,int m,int s){
        int minCol=s-1;
        int maxCol=m-s;
        int minRow=s-1;
        int maxRow=n-s;
        int resSize=2*(maxRow-minRow+(maxCol-minCol));
        int[] resArr=new int[resSize];
        int tmp=0;

            //left wall
            for(int i=minRow;i<=maxRow;i++){
                resArr[tmp]=arr[i][minCol];
                ++tmp;
            }
            minCol++;
            //bottom wall
            for(int i=minCol;i<=maxCol;i++){
                resArr[tmp]=arr[maxRow][i];
                ++tmp;
            }
            maxRow--;
            //right wall
            for(int i=maxRow;i>=minRow;i--){
                resArr[tmp]=arr[i][maxCol];
                ++tmp;
            }
            maxCol--;
            //top wall
            for(int i=maxCol;i>=minCol;i--){
                resArr[tmp]=arr[minRow][i];
                ++tmp;
            }
        
        return resArr;   
    }
    public static int[] reverse(int[] arr,int k){
        int n=arr.length;
        
        //bring k to range and make it positive if k<0
         k= k<0?k%n+n:k%n;
         int l;
         int r;
         //reverse from 0 to n-k-1
         r=n-k-1;
         l=0;
         while(l<r){
           arr[l]=arr[l]+arr[r];
           arr[r]=arr[l]-arr[r];
           arr[l]=arr[l]-arr[r];

           l++;
           r--;
         }
          //reverse from n-k to n-1
          r=n-1;
          l=n-k;
          while(l<r){
            arr[l]=arr[l]+arr[r];
            arr[r]=arr[l]-arr[r];
            arr[l]=arr[l]-arr[r];
 
            l++;
            r--;
          }

          //reverse whole arr
          r=n-1;
          l=0;
          while(l<r){
            arr[l]=arr[l]+arr[r];
            arr[r]=arr[l]-arr[r];   
            arr[l]=arr[l]-arr[r];
 
            l++;
            r--;
          }
          return arr;
    }
    public static void setArray(int[][] arr,int n,int m,int s,int[] resArr){
        int minCol=s-1;
        int maxCol=m-s;
        int minRow=s-1;
        int maxRow=n-s;
        int tmp=0;

            //left wall
            for(int i=minRow;i<=maxRow;i++){
                arr[i][minCol]=resArr[tmp];
                ++tmp;
            }
            minCol++;
            //bottom wall
            for(int i=minCol;i<=maxCol;i++){
                arr[maxRow][i]=resArr[tmp];
                ++tmp;
            }
            maxRow--;
            //right wall
            for(int i=maxRow;i>=minRow;i--){
                arr[i][maxCol]=resArr[tmp];
                ++tmp;
            }
            maxCol--;
            //top wall
            for(int i=maxCol;i>=minCol;i--){
                arr[minRow][i]=resArr[tmp];
                ++tmp;
            }
    }
    public static void display(int[][] arr){
        for(int[] i:arr){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] arr=new int[n][m];
        takeInput(arr, n, m);
        int s=scanner.nextInt();
        int r=scanner.nextInt();
        int[] arr1=extract1DArr(arr,n,m,s);
        int[] arr2=reverse(arr1,r);
        setArray(arr,n,m,s,arr2);
        display(arr);
    }
}

package Main.Arrays_Funcs;

import java.util.Scanner;

public class ExitPointOfAMatrix {
    static Scanner scanner = new Scanner(System.in);

    public static void takeInput(int[][]arr,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                arr[i][j]=scanner.nextInt();
        }
    }
    public static void main(String[] args) {
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] a1=new int[n][m];
        takeInput(a1,n,m);
        int[] res=findExit(a1, n);
        for(int i:res)System.out.println(i);
    }
    public static  int[] findExit(int[][] arr,int n){
        int[] res=new int[2];
        int i=0,j=0,r=0,c=0,dir=0;
        while(i>=0 &&  i<n  && j>=0 &&  j<arr[0].length){
                dir=(dir+arr[i][j])%4;//0,1,2,3
                
                if(dir==0){
                    c=j;
                    j++;
                }
                else if(dir==1){
                    r=i;
                    i++;
                }
                else if(dir==2){
                    c=j;
                    j--;
                }
                else {
                    r=i;
                    i--;
                }
        }
        res[0]=r;
        res[1]=c;
        return res;
    }

}

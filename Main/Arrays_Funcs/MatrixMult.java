package Main.Arrays_Funcs;

import java.util.Scanner;

public class MatrixMult {
    static Scanner scanner = new Scanner(System.in);

    public static void takeInput(int[][] arr,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
    }
    public static int[][] matrixMult(int[][] a1,int[][] a2){
        int[][] res=new int[a1.length][a2[0].length];
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                for(int k=0;k<a1[0].length;k++){
                    res[i][j] += a1[i][k]*a2[k][i];
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int n1=scanner.nextInt();
        int m1=scanner.nextInt();
        int[][] a1=new int[n1][m1];
        takeInput(a1, n1, m1);

        int n2=scanner.nextInt();
        int m2=scanner.nextInt();
        int[][] a2=new int[n2][m2];
        takeInput(a2, n2, m2);
        if(m1!=n2){
            System.out.println("Invalid input");
            return;
        }
        int[][] res=matrixMult(a1, a2);
        for(int[] i:res){
            for(int j:i)System.out.print(j+" ");

            System.out.println();
        }
        
    }
}

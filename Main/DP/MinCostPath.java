package Main.DP;

import java.io.*;
import java.util.*;

public class MinCostPath {

  public static int findMinCost(int[][] arr, int[][] dp, int i, int j) {
    if(i == arr.length - 1 && j == arr[0].length - 1) {
      return arr[i][j];
    }
    if(dp[i][j] != 0) return dp[i][j];

    //to avoid negative values if grom a cell we cannot move anywhere
    int minCost = (int)1e9;
    if(i < arr.length - 1) {
       minCost = Math.min(findMinCost(arr, dp, i + 1, j), minCost) ;
    }

    if(j < arr[0].length - 1) {
      minCost = Math.min(findMinCost(arr, dp, i , j + 1), minCost) ;
   }
   return dp[i][j] =  minCost + arr[i][j];
  }

  public static int findMinCost_tab(int[][] arr, int[][] dp) {
   
    for(int i = arr.length -1 ; i >= 0; i--) {
      for(int j = arr[0].length -1; j >= 0 ;j-- )
        if(i == arr.length-1 && j == arr[0].length - 1 ) {
          dp[i][j] = arr[i][j];
        }
        else if(i == arr.length-1) {
          //last row
          dp[i][j] = dp[i][j + 1] + arr[i][j];
        }
        else if(j == arr[0].length-1) {
          //last col
          dp[i][j] = dp[i + 1][j] + arr[i][j];
        }
        else {
          dp[i][j] = arr[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);
        }
    }
    return dp[0][0];
  }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
          for(int j = 0; j < m; j++) {
            arr[i][j] = sc.nextInt();
          }
        }
        
        int[][] dp = new int[n][m]; 
        int res = findMinCost(arr, dp, 0, 0);
        System.out.println(res);
    }

}

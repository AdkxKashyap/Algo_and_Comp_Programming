package DP;

import java.util.*;

public class PartitionSubsets {
  public static int count(int n, int k, int[][] dp) {
    for(int i = 0; i <= n; i++) {
      for(int j = 0; j <= k; j++) {
        if(i == j) {
          dp[i][j] = 1;
        }else if(i < j) {
          dp[i][j] = 0;
        }else {
          dp[i][j] = dp[i-1][j-1] + dp[i-1][j] * j;
        }
      }
    }
    return dp[n][k];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[][] dp = new int[n+1][k+1];
    int res = count(n, k, dp);
    System.out.println(res);
  }
}

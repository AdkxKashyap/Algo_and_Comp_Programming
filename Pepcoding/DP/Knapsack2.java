package DP;

import java.util.Scanner;

//unbounded knapsack
public class Knapsack2 {
  public static int maxval(int[] vals, int[] wts, int cap, int[] dp) {
    for(int i = 1; i <= cap; i++) {
      // int max = 0;
      for(int j = 0; j < vals.length; j++) {
        if(i - wts[j] >= 0) {
          dp[i] = Math.max(dp[i], vals[j] + dp[i - wts[j]]); 
        }
      }
    }
    return dp[cap];
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] vals = new int[n];
    int[] wts = new int[n];
    for(int i = 0; i < vals.length; i++) {
      vals[i] = sc.nextInt();
    }
    for(int i = 0; i < wts.length; i++) {
      wts[i] = sc.nextInt();
    }
    int cap = sc.nextInt();
    int[] dp = new int[cap + 1];
    int res = maxval(vals, wts, cap, dp);
  }
}

package DP;

import java.io.*;
import java.util.*;
public class ClimbStairs2 {

  //memoization
  public static int count(int stair, int[] dp, int[] arr, int n) {
    if(stair > n) return 0;
    if(stair == n) return 1;
    if(dp[stair] != 0) return dp[stair];
    int sum = 0;
    int climbWays = arr[stair];
    for(int i = 1; i <= climbWays; i++) {
      sum += count(stair + i, dp, arr, n);
    }
    return dp[stair] = sum;
  }
  public static void main(String[] args) throws Exception {
      // write your code here
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int[] arr  = new int[n];
      for(int i = 0; i < n; i++ ) {
        arr[i] = scanner.nextInt();
      }
      System.out.println(count(0, new int[n + 1], arr, n));
  }
}
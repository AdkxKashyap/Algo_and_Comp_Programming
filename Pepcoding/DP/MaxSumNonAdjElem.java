package DP;

import java.util.*;

public class MaxSumNonAdjElem {
  public static int maxSum_memo(int[] arr, int indx, int last, int[][] dp) {
    if(indx == -1) {
      return dp[indx + 1][last] = 0;
    }
    if(dp[indx + 1][last] != -1) return dp[indx][last];
    int max = (int)-1e9;
    if(last == 0) {
      max = maxSum_memo(arr, indx - 1, 1, dp) + arr[indx];
    }
    max = Math.max(max , maxSum_memo(arr, indx - 1, 0, dp));
    return dp[indx + 1][last] = max;
  }
//greedy approach is used here see dp video
  public static int maxSum_tab(int[] arr) {
    int incl = arr[0];
    int excl = 0;

    for(int i = 1; i < arr.length; i++) {
      int tmp = incl;
      incl = arr[i] + excl;
      excl = Math.max(tmp, excl);
    }
    return Math.max(incl,excl);
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int[][] dp = new int[n + 1][2];
    Arrays.fill(arr, -1);
    int max = maxSum_memo(arr, n-1, 0, dp);
    System.out.println(max);
  }
}

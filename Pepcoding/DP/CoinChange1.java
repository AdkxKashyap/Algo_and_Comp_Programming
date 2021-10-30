package DP;

import java.util.Scanner;

//coin change permutation,one coin can be taken infinite number of times
public class CoinChange1 {
  public static int coinChange_memo(int tar, int[] arr, int[] dp) {
    if(tar == 0) return 1;
    if(tar < 0) return 0;
    if(dp[tar] != -1) return dp[tar];
    int count = 0;
    for(int i = 0; i < arr.length; i++) {
      count += coinChange_memo(tar - arr[i], arr, dp);
    }
    return dp[tar] = count;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int tar = sc.nextInt();
    int[] dp = new int[tar+1];
    for(int i = 0; i < dp.length; i++){
      dp[i] = -1;
    }
    int count = coinChange_memo(tar, arr, dp);
  }
}

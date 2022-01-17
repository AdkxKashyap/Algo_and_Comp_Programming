package Main.DP;
//coin change combo
import java.io.*;
import java.util.*;

public class CoinChange2 {
  public static int coinChange_memo(int tar, int[] arr, int[][] dp, int lstIndx) {
    if(tar == 0) return dp[tar][lstIndx] = 1;
    if(tar < 0) return  0;
    if(dp[tar][lstIndx] != -1) return dp[tar][lstIndx];
    int count = 0;
    for(int i = lstIndx; i < arr.length; i++) {
      count += coinChange_memo(tar - arr[i], arr, dp, i);
    }
    return dp[tar][lstIndx] = count;
  }
  
   public static int coinChange_tab(int tar, int[] coins, int[] dp) {
    for(int coin : coins) {
        for(int j = coin; j <= tar; j++) {
            if(j - coin >= 0) {
                dp[j] += dp[j - coin];
            }
        }
    }
    return dp[tar];
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int tar = sc.nextInt();
    // int[][] dp = new int[tar+1][arr.length];
    // for(int i = 0; i < dp.length; i++){
    //     for(int j = 0; j < dp[0].length; j++)
    //         dp[i][j] = -1;
    // }
    int[] dp = new int[tar + 1];
    dp[0] = 1;
    int count = coinChange_tab(tar, arr, dp);
    System.out.println(count);
  }
}

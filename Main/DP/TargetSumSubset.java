package Main.DP;

import java.io.*;
import java.util.*;

public class TargetSumSubset {
  public static boolean targetSum_memo(int[] arr, Boolean[][] dp, int indx, int target) {
    if (target == 0)
      return true;
    if (dp[indx][target] != null)
      return dp[indx][target];
    if (indx == arr.length)
      return dp[indx][target] = false;

    if (target - arr[indx] >= 0) {
      // yes call
      dp[indx][target] = targetSum_memo(arr, dp, indx + 1, target - arr[indx]);
      if (dp[indx][target] == true)
        return true;
    }
    // no call
    dp[indx][target] = targetSum_memo(arr, dp, indx + 1, target);
    return dp[indx][target];
  }

  public static boolean targetSum_tab(int[] arr, int tar) {
    boolean[] dp = new boolean[tar + 1];
    dp[0] = true;
    for (int i = 0; i < arr.length; i++) {
      boolean[] tmp_dp = new boolean[tar + 1];
      tmp_dp[0] = true;
      for (int j = 1; j <= tar; j++) {
        if (dp[j] == true || (j - arr[i] >= 0 && dp[j - arr[i]] == true))
          tmp_dp[j] = true;
        else
          tmp_dp[j] = false;
      }
      dp = tmp_dp;
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
    Boolean[][] dp = new Boolean[n+1][tar+1];
    for(int i = 0; i < dp.length; i++){
    for(int j = 0; j < dp[0].length; j++){
    dp[i][j] = null;
    }
    }
    // boolean res = targetSum_memo(arr, dp, 0, 3);
    boolean res = targetSum_tab(arr, tar);
    System.out.println(res);
  }
}

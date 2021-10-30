package DP;

import java.io.*;
import java.util.*;

public class ClimbStairs {
    public static int count(int stair, int[] dp, int n) {
      if(stair > n) return 0;
      if(stair == n) return 1;
      if(dp[stair] != 0) return dp[stair];
      int res1 = count(stair + 1, dp, n);
      int res2 = count(stair + 2, dp, n);
      int res3 = count(stair + 3, dp, n);
      return dp[stair] = res1 + res2 + res3;
    }

    //tabulation
    public static int countTab(int stair, int[] dp, int n) {
       dp[0] = 1;
      for(int i = 1; i <= n; i ++){
        if(i >= 3) dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        if(i >= 2) dp[i] = dp[i - 1] + dp[i - 2];
        else dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
      } 
      return dp[n];
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(count(0, new int[n + 1], n));
    }

}

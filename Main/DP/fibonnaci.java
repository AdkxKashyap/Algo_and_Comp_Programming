package Main.DP;

import java.io.*;
import java.util.*;

public class fibonnaci{

  //tabulation
  public static int fibonnaci(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for(int i = 2; i <= n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    } 
    return dp[n];
  }
public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int res = fibonnaci(n);
    System.out.println(res);
 }

}
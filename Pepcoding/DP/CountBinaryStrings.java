package DP;

import java.util.Scanner;

public class CountBinaryStrings {
  public static int count(int len, int lsf, int lastStr, int[][] dp) {
    if(lsf == len) return dp[lsf][lastStr] =  1;
    if(dp[lsf][lastStr] != 0) return dp[lsf][lastStr];
    int count = 0;
    if(lastStr == 1) {
      count += count(len, lsf + 1, 0, dp);
    }
      count += count(len, lsf + 1, 1, dp);
      return dp[lsf][lastStr] = count;
  }

  public static int count_tab(int len) {
    int str0 = 1;
    int str1 = 1;
    for(int i = 1; i <= len; i++) {
      int tmp = str0;
      str0 = str1;
      str1 = tmp + str1;
    }
    return str1 + str0;
  } 
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] dp = new int[n + 1][2];
    int cnt = count(n, 0, 1, dp);
    System.out.println(cnt);
  }
}

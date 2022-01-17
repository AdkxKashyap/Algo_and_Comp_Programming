package Main.DP;

import java.util.Scanner;

public class Tiling2 {

  //take long instead of int
  //tiles are of length m 
  public static int tiles(int n, int m) {
    int[] dp = new int[n + 1];

    for(int i = 0; i <= n; i++) {
      if(i < m) {
        dp[i] = 1;
      }
      else {
        dp[i] = dp[i - 1] + dp[i - m];
      } 
    }
    return dp[n];
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int res = tiles(n, m);
    System.out.println(res);
  }
}

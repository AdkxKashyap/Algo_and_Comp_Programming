package Main.DP;

import java.util.Scanner;

//o 1 knapsack
public class Knapsack1 {
  public static int knapsack(int[] val, int[] wts, int indx, int cap, int[][] dp){
    if(indx == val.length) return dp[indx][cap] =  0;
    if(dp[indx][cap] != 0) return dp[indx][cap];
    int maxval = 0;
    //yes call
    if(cap - wts[indx] >= 0) {
      maxval =  Math.max(maxval, val[indx] + knapsack(val, wts, indx + 1, cap - wts[indx], dp));
    }
    //no call
    maxval = Math.max(maxval, knapsack(val, wts, indx + 1, cap, dp));
    return dp[indx][cap] = maxval;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] val = new int[n];
    int[] wts = new int[n];
    for(int i = 0; i < n; i++) {
      val[i] = sc.nextInt();
    }
    for(int i = 0; i < n; i++) {
      wts[i] = sc.nextInt();
    }
    int cap = sc.nextInt();
    int[][] dp = new int[n+1][cap+1];
    int max = knapsack(val, wts, 0, cap, dp);
    System.out.println(max);
  }
}

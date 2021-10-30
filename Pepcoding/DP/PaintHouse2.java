package DP;
import java.util.*;
public class PaintHouse2 {
  public static int paintHouse(int[][] cost, int[][] dp) {
    int n = cost.length;
    int k = cost[0].length;
    int min = Integer.MAX_VALUE;
    //if we reach a cell in a row whic is just below the min we will not be able to use that since we cannot use same colour,in that case we use second min;
    int secondMin = Integer.MAX_VALUE;

    for(int i = 0; i < n; i++) {
      int tmpMin = Integer.MAX_VALUE;
      int tmpSecondMin = Integer.MAX_VALUE;
      for(int j = 0; j < k; j++) {
        if(i == 0) {
          dp[i][j] = cost[i][j];
        }else {
          if(dp[i - 1][j] != min) {
            dp[i][j] = cost[i][j] + min;
          }else {
            dp[i][j] = cost[i][j] + secondMin;
          }
        }
        if(dp[i][j] <= tmpMin) {
          tmpSecondMin = tmpMin;
          tmpMin = dp[i][j];
        }else if(dp[i][j] < tmpSecondMin) {
          tmpSecondMin = dp[i][j];
        }
      }
      min = tmpMin;
      secondMin = tmpSecondMin;
    }
    return min;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[][] cost = new int[n][k];
    int[][] dp = new int[n][k];
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < k; j++) {
        cost[i][j] = sc.nextInt();
      }
    }
    int res = paintHouse(cost, dp);
    System.out.println(res);
  }
}

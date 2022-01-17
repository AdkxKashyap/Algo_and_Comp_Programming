package Main.DP;
import java.io.*;
import java.util.*;

public class Goldmine {
  public static int findMaxGold(int[][] mine) {
    int res = 0;
    for(int j = mine[0].length-1; j >= 0; j--) {
        for(int i = 0; i < mine.length; i++) {
            int max = 0;
            //top-left
            if(i-1 >= 0 && j+1 < mine[0].length) {
                max = mine[i-1][j+1];
            }if(j+1 < mine[0].length) {
                //right
                max = Math.max(max, mine[i][j+1]);
            }if(i+1 < mine.length && j+1 < mine[0].length) {
                //bottom right
                max = Math.max(max, mine[i+1][j+1]);
            }
            mine[i][j] = mine[i][j] + max;
            res = Math.max(mine[i][j], res);
        }
    }
    return res;
}
  public static int findMaxGold(int[][] mine, int[][] dp) {
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < mine.length; i++) {
      max = Math.max(max, helper(mine, dp, i, 0));
    }
    return max;
  }

  public static int helper(int[][] mine, int[][] dp, int i, int j) {
    if(dp[i][j] != 0) return dp[i][j];
    int cost = Integer.MIN_VALUE;
    
    //go top-right
    if(i - 1 >= 0) {
      cost =  Math.max(cost, helper(mine, dp, i - 1 , j + 1));
    }
    //go right
    if(j + 1 < mine[0].length) {
      cost = Math.max(cost, helper(mine, dp, i , j + 1));
    }
    //go down-right
    if(i + 1 < mine.length) {
      cost = Math.max(cost, helper(mine, dp, i + 1 , j + 1));
    }
    return dp[i][j] = mine[i][j] + cost;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] arr = new int[n][m];
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    int[][] dp = new int[n][m];
    int res = findMaxGold(arr, dp);
    System.out.println(res);
  }
}

package Main.DP;

import java.io.*;
import java.util.*;

public class BuySellStocks6 {
    
    public static int maxProfit(int[] prices, int k) {
        int[][] dp = new int[k+1][prices.length];
        for(int trans = 1; trans <= k; trans++) {
            int max  = dp[trans- 1][0] - prices[0];
            for(int day = 1; day < prices.length; day++) {
                dp[trans][day] = Math.max(dp[trans][day-1], max + prices[day]);
                max = Math.max(max, dp[trans - 1][day] - prices[day]);
            }
        }
        return dp[k][prices.length - 1];
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int res = maxProfit(prices, k);
        System.out.println(res);
    }

}

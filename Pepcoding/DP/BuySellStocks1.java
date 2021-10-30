package DP;

import java.io.*;
import java.util.*;

//Buy And Sell Stocks - One Transaction Allowed
public class BuySellStocks1 {
    public static int maxProfit(int[] prices) {
        int minCost = prices[0];
        int profit = 0;
        for(int day = 1; day < prices.length; day++) {
            profit = Math.max(profit, prices[day] - minCost);
            minCost = Math.min(minCost, prices[day]);
        }
        return profit;
    } 
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        int res = maxProfit(prices);
        System.out.println(res);
    }

}

package Main.DP;

import java.io.*;
import java.util.*;

public class BuySellStocks5 {
    
    public static int maxProfit(int[] prices) {
        //left -> right,Max(profit selling at i, profit upto i - 1)       
        int[] lr = new int[prices.length];
        lr[0] = 0;
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > minPrice) {
                lr[i] = Math.max(prices[i] - minPrice, lr[i - 1]);
            }
            else {
                //update min price
                minPrice = prices[i];
                lr[i] = lr[i - 1];
            }
        }
        //right -> left, Max(profit buying at i, profit upto i + 1)
        int[] rl = new int[prices.length];
        rl[0] = 0;
        int maxPrice = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--) {
            if(prices[i] < maxPrice) {
                rl[i] = Math.max(maxPrice - prices[i], rl[i + 1]);
            }
            else {
                //update min price
                maxPrice = prices[i];
                rl[i] = rl[i + 1];
            }
        }
        int maxP = lr[0] + rl[0];
        for(int i = 1; i < prices.length; i++) {
            maxP = Math.max(maxP, lr[i] + rl[i]);
        }
        return maxP;
        
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

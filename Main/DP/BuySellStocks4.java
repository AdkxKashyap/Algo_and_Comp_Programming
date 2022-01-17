package Main.DP;

import java.io.*;
import java.util.*;
//Buy And Sell Stocks With Cooldown - Infinite Transaction Allowed
public class BuySellStocks4 {
    public static int maxProfit(int[] prices) {
        int pbuy = -prices[0];
        int psell = 0;
        int pcool = 0;//cooldown profit
        for(int i = 0; i < prices.length; i++) {
            int tmpb = Math.max(pbuy, pcool - prices[i]);
            int tmps = Math.max(psell, prices[i] + pbuy);
            int tmpc = Math.max(pcool, psell);//here cooldown is 1 so checking prev day sell.if cooldown = k check sell[i - k]
            pbuy = tmpb;
            psell = tmps;
            pcool = tmpc;
        }
        return psell;
    }
    public static void main(String[] args) throws Exception {
        // write your code here
         Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i  < n; i++) {
            prices[i] = sc.nextInt();
        }
        int res = maxProfit(prices);
        System.out.println(res);
    }

}

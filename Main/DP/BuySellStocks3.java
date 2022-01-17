package Main.DP;
//Buy And Sell Stocks With Transaction Fee - Infinite Transactions Allowed
import java.io.*;
import java.util.*;

public class BuySellStocks3 {
    public static int maxProfit(int[] prices, int fee) {
        int pbuy = -prices[0];//on day0 we will buy 
        int psell = 0;//prev sell is 0 since we havent made any profit yet.
        for(int i = 1; i < prices.length; i++){
            int tmpbuy = Math.max(pbuy, psell - prices[i]);
            int tmpsell = Math.max(psell, (prices[i] + pbuy) - fee);
            pbuy = tmpbuy;
            psell = tmpsell;
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
        int fee = sc.nextInt();
        int res = maxProfit(prices, fee);
        System.out.println(res);
    }

}
/**lc714 
 * Best Time to Buy and Sell Stock with Transaction Fee
 * also see lc122
 * At i th day We can either buy or sell prev held stock or do nothing. 
 * Buy->At i th day if I buy than I have to sell prev held stock since we can have only 
 * 1 stock.Buy means money out of my pocket.So Buy will be max profit I had up until
 * today-current price of stock.So buy will be Max of max profit held upuntil today-
 * current price and max money i had in my pocket up until i-1 day;
 * 
 * Sell->Sell means money coming to pocket.To sell I must buy.
 * so sell will be Max of max profit I had up until i-1 day and  max money left in
 * my pocket after buying share at i-1 day + a[i]
 */
class StockMarket {
    public int maxProfit(int[] prices, int fee) {
        int buy=-prices[0];//buying at 0th day.a[0] amt will be deducted .
        int sell=0;//nothing to sell at ith day

        for(int i=1;i<prices.length;i++){
            buy=Math.max(buy, sell-prices[i]);
            sell=Math.max(sell, prices[i]+buy-fee);
        }
        return sell;
    }
}
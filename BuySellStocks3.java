//Best Time to Buy and Sell Stock III
/**See lc714
 * To buy we need to sell previously held stock.We can buy sell on same day.Buy sell the same stock
 * completes one transaction.Max 2 allowed.
 * buyOne->Buying the 1st stock.Buying takes money out of pocket.Max of max money by prev held stock and current stock
 * sellOne->selling the 1st stock.Money comes to pocket.
 * buyTwo->selling 1st stock and with that money buying new one 
 * sellTwo-> sell stock two and add that to profits from 1st stock.
 * 
 * we can either be at prev buy sell state or can move to better state.We need to look at each state we are in
 */

public class BuySellStocks3 {
    public int maxProfit(int[] prices) {
       int buyOne=-prices[0];//buying 1st stock.No prev stock to sell.
       int buyOneSellOne=0;//selling the 1st stock that was brought.No prev profits.
       int buyTwo=-prices[0];//buying 2nd stock by selling prev one
       int buyTwoSellTwo=0;//Selling the 2nd stock 

       for(int i=1;i<prices.length;i++){
        buyOne=Math.max(buyOne, -prices[i]);
        buyOneSellOne=Math.max(buyOneSellOne, prices[i]+buyOne);
        buyTwo=Math.max(buyTwo, buyOneSellOne-prices[i]);
        buyTwoSellTwo=Math.max(buyTwoSellTwo, buyTwo+prices[i]);
       }
       return buyTwoSellTwo;
    }
}

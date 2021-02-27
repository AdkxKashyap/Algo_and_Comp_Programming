// Best Time to Buy and Sell Stock IV
//see lc714
public class BuySellStocks4 {
    public int maxProfit(int k, int[] prices) {
        int buy[]=new int[k];int sell[]=new int[k];
        if(prices.length==0 || k==0){
            return 0;
        }
        for(int i=0;i<k;i++){
            buy[i]=-prices[0];
        }
        for(int i=1;i<prices.length;i++){
            for(int j=0;j<k;j++){
                if(j==0){
                    buy[0]=Math.max(buy[0], -prices[i]);
                    sell[0]=Math.max(sell[0], prices[i]+buy[0]);
                }
                else{
                    buy[j]=Math.max(buy[j],sell[j-1]-prices[i] );
                    sell[j]=Math.max(sell[j], buy[j]+prices[i]);
                }
            }
        }
        return sell[k-1];
    }
       
}


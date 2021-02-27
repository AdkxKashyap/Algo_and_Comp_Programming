import java.util.Arrays;

//Coin change
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];//arr size will be 12 so that index i can reach 11
        Arrays.fill(dp,amount+1);
        dp[0]=0;//base case of top-down
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                dp[i]  =  i>=coins[j]?Math.min(dp[i], dp[i-coins[j]]+1):dp[i];
            }
        }
        return dp[amount+1]==amount+1?-1:dp[amount+1];
    }

    //TOP-DOWN
    // public int helper(int[] coins,int amount,int memo[]){
    //     if(amount<=0){
    //         if(amount<0){
    //             return Integer.MAX_VALUE;
    //         }
    //         return 0;
    //     }
    //     if(memo[amount]!=0)return memo[amount];
    //     int min=Integer.MAX_VALUE;
    //     for(int i=0;i<coins.length;i++){
    //         int res=helper(coins, amount-coins[i], memo);
    //         if(res>=0 && res<min){
    //             min=res+1;
    //         }
    //     }
    //     memo[amount]=min==Integer.MAX_VALUE?-1:min;
    //     return memo[amount];
    // }
    // public int coinChange(int[] coins, int amount) {
    //     int memo[]=new int[amount+1];
    //     int res=helper(coins, amount, memo);
    //     if(res==Integer.MAX_VALUE)return -1;
    //     return res;
    // }
}

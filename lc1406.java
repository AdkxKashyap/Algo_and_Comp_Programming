//Stone game-3
//https://www.youtube.com/watch?v=HsY3jFyaePU&t=0s
public class lc1406 {
    public String stoneGameIII(int[] stoneValue) {
        int length=stoneValue.length;
        int dp[]=new int[3];
        int i=length-1;
        while(i>=0){
            int ans=Integer.MIN_VALUE;
            ans=Math.max(ans, stoneValue[i]-dp[(i+1)%3]);
            if(i+1<length){
                ans=Math.max(ans, stoneValue[i]+stoneValue[i+1]-dp[(i+2)%3]);
            }
            if(i+2<length){
                ans=Math.max(ans, stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-dp[(i+3)%3]);
            }
            dp[i%3]=ans;
            i--;
        }
        if(dp[0]>0){
            return "Alice";
        }
        if(dp[0]==0){
            return "Tie";
        }
        return "Bob";
    }
}

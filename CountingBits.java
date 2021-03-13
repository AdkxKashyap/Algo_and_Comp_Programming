
//https://leetcode.com/problems/counting-bits/discuss/79557/How-we-handle-this-question-on-interview-Thinking-process-%2B-DP-solution
public class CountingBits {
    public int[] countBits(int num) {
        int[] dp=new int[num+1];
        int offset=1;
        dp[0]=0;
        for(int i=0;i<=num;i++){
            if(i==offset*2)offset*=2;
            dp[i]=dp[i-offset]+1;
        }
        return dp;
    }
    public static void main(String[] args) {
        int[] res=new CountingBits().countBits(32);
        for(int i:res)System.out.print(i+",");
    }
}

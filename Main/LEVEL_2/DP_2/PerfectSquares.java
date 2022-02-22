public class PerfectSquares {
  public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1; //we can create a sum 1 using only 1 perfect sq i.e 1 itself

        for(int i = 2; i <= n; i++) {
          int min = Integer.MAX_VALUE;
          for(int j = 1; j*j <= i; j++) {
            min = Math.min(min, dp[i-(j*j)]);
          }
          dp[i] = min+1;
        }
        return dp[n];
  }
}

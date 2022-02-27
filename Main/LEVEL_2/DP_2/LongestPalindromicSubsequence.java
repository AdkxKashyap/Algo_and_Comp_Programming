public class LongestPalindromicSubsequence {
  public int longestPalinSubseq(String S)
  {
      //code here
      int[][] dp = new int[S.length()][S.length()];
      int n = S.length();
      int max = Integer.MIN_VALUE;
      //d-> Diagonal. we traverse diagonally
      for(int d = 0; d < n; d++) {
        for(int i = 0, j = d; j < n; i++, j++) {
          if(d == 0) {
            dp[i][j] = 1;
          } else {
            if(S.charAt(i) == S.charAt(j)) {
              dp[i][j] = dp[i+1][j-1] + 2;
            } else {
              dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
            }
          }
          max = Math.max(max, dp[i][j]);
        }
      }
      return max;
  }
}

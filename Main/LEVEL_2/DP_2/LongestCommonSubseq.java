public class LongestCommonSubseq {
  public static int findLCS(String s1, String s2) {
    int n1 = s1.length();
    int n2 = s2.length();
    int[][] dp = new int[n1+1][n2+1];
    for(int i = n1-1; i >= 0; i--) {
      for(int j = n2-1; j >= 0; j--) {
        if(s1.charAt(i) == s2.charAt(j)) {
          dp[i][j] = dp[i+1][j+1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
        }
      }
    }
    return dp[0][0];
  }
}

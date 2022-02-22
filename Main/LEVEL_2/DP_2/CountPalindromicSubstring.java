public class CountPalindromicSubstring {
  public int CountPS(String S, int N)
  {
      //code here
      if(N < 2) return 0;
      boolean[][] dp = new boolean[N][N];
      int count = 0;

      for(int d = 0; d < N; d++) {
        for(int i = 0,  j = d; j < N; i++, j++) {
          //first diagonal
          if(d == 0) {
            dp[i][j] = true;
          } else if(d == 1) {
            //second diagonal
            if(S.charAt(i) == S.charAt(j)) {
              dp[i][j] = true;
            } else {
              dp[i][j] = false;
            }
          } else {
            if(S.charAt(i) == S.charAt(j) && dp[i+1][j-1] == true) {
              dp[i][j] = true;
            } else {
              dp[i][j] = false;
            }
          }
          if(dp[i][j]){
            count++;
          }
        }
      }

      return count;
  }
}

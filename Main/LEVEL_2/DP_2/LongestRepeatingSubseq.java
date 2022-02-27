public class LongestRepeatingSubseq {
  //O(N) space
  public int LongestRepeatingSubsequence(String str)
  {
      // code here
      int n = str.length();
      int[] dp = new int[n+1];
      for(int i = n-1; i >= 0; i--) {
        int[] tmp = new int[n+1];
        for(int j = n-1; j >= 0; j--) {
          char c1 = str.charAt(i-1);
          char c2 = str.charAt(j-1);
          if(c1 == c2 && i != j) {
            tmp[j] = dp[j+1] + 1;
          } else {
            tmp[j] = Math.max(tmp[j+1], dp[j]);
          }
        }
      }
      return dp[0];
  }
}

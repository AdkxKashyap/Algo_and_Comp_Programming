class SolvingQuestionsWithBrainpower {
  public long mostPoints(int[][] questions) {
      // long[] dp = new long[questions.length];
      // return dfs(questions, 0, dp);

      long[] dp = new long[questions.length+1];
      return iterative(questions, dp);
  }
  //similar to jump game
  // public long dfs(int[][] q, int i, long[] dp) {
  //     if(i >= q.length) return 0;
  //     if(dp[i] > 0) return dp[i];
      
  //     int points = q[i][0];
  //     int jumps = q[i][1]+1;
  //     //yes
  //     long yans = dfs(q, i+jumps, dp) + points;
  //     //No
  //     long nans = dfs(q, i+1, dp);
      
  //     return dp[i] = Math.max(yans, nans);
  // }

   public long iterative(int[][] q, long[] dp) {
    int n = q.length;
    for(int i = n-1; i >= 0; i--) {
      int points = q[i][0];
      int jumps = q[i][1];
      dp[i] = Math.max(points+dp[Math.min(i+jumps, n)], dp[i+1]);
    }
    return dp[0];
   }
}
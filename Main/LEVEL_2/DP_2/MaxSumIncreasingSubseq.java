public class MaxSumIncreasingSubseq {
  public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
      if(n == 0) return 0;
      int max = arr[0];
	    int[] dp = new int[n];
      dp[0] = arr[0];
      for(int i = 1; i < n; i++) {
        int tmp = 0;
        for(int j = 0; j < i; j++) {
          if(arr[j] < arr[i]) {
            tmp = Math.max(tmp, dp[j]);
          }
        }
        dp[i] = arr[i]+tmp;
        max = Math.max(dp[i], max);
      }
      return max;
	}  
}

public class LargestSubmatrixWithOnes {
  public static int solution(int[][] arr) {
		//write your code here
    int max = 0;
    int[][] dp = new int[arr.length][arr[0].length];
    for(int i = dp.length-1; i >= 0; i--) {
      for(int j = dp[0].length-1; j >= 0; j--) {
        if(i == dp.length-1) {
          dp[i][j] = arr[i][j];
        } else if(j == dp[0].length-1) {
          dp[i][j] = arr[i][j];
        } else {
          if(arr[i][j] == 1) {
            dp[i][j] = Math.min(dp[i][j+1], Math.min(dp[i+1][j+1], dp[i+1][j])) + 1;
          }
        }
        max = Math.max(dp[i][j], max);
      }
    }
		return max;
	}
}

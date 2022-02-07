//https://leetcode.com/problems/target-sum/
public class TargetSum {
  public int findTargetSumWays(int[] nums, int target) {
    int sum = 0;
    for(int val : nums) {
      sum += val;
    }
     if(sum < target || -sum > target) return 0; 
    // using 1D array insted 0f 2D
    int[] dp = new int[sum*2 + 1];
    /**dp[0] = 1, 
     * here sum is idx 0
     * eg if sum = 5
     * -5 to +5 , 
    */
    dp[sum] = 1;
    for(int i = 0; i < nums.length; i++) {
      int[] tmp = new int[sum*2+1];
      for(int j = 0; j < dp.length; j++) {
        if(dp[j] != 0) {
          //-
          tmp[j-nums[i]] += dp[j];
          //+
          tmp[j+nums[i]] += dp[j];
        }
      }
      dp = tmp;
     }
     return dp[sum+target];
}
}

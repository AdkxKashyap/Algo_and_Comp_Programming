package Main.LEVEL_2.Arrays_Strings;
//lc209
class MinimumSizeSubarraySum {
  public int minSubArrayLen(int target, int[] nums) {
      int left = 0;
      int sum = 0;
      int res = Integer.MAX_VALUE;
      for(int i = 0; i < nums.length; i++) {
        if(nums[i] >= target) return 1;
        sum += nums[i];
        while(sum >= target) {
          res = Math.min(res, (i-left)+1);
          sum-=nums[left];
          left++;
        }
      }
      return res == Integer.MAX_VALUE ? 0 : res;
  }
}
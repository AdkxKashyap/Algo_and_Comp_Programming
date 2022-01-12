class NumberofsubarrayWithBoundeMax {
  public int numSubarrayBoundedMax(int[] nums, int left, int right) {
      return count(nums, right) - count(nums, left-1);
  }
  public int count(int[] nums, int bound) {
      int ans = 0;
      int count = 0;
      for(int val : nums) {
          //count consequtive nums less than bound. we need this to find subarrays
          if(val <= bound) count++;
          else count = 0;
          
          //count subarr
          ans += count;
      }
      return ans;
  }
}
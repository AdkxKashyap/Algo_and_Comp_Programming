public class FindPivotIndex {
  public int pivotIndex(int[] nums) {
    int sum = 0;
    int prefixSum = 0;
    for (int val : nums)
      sum += val;

    //find prefix
    for(int i = 0; i < nums.length; i++) {
      if(prefixSum * 2 == sum-nums[i]) {
        return i;
      }
      prefixSum += nums[i];
    }
    return -1;
  }
}

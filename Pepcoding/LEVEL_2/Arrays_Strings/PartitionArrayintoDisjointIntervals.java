//lc - 915
public class PartitionArrayintoDisjointIntervals {
  public int partitionDisjoint(int[] nums) {
    int leftmax = nums[0];
    int greatest = nums[0];
    int ans = 0;
    for(int i = 1; i < nums.length; i++) {
        if(nums[i] > greatest) {
            greatest = nums[i];
        }else if(nums[i] < leftmax) {
            ans = i;
            leftmax = greatest;
        }
    }
    return ans+1;
}
}

package Main.LEVEL_2.Arrays_Strings;
public class MaximumAverageSubarray {
  public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int left = 0;
        double res = Integer.MIN_VALUE *1d;

        //sum of 1st K elements;
        for(int i = 0; i < k; i++) {
          sum += nums[i];
        }
        res = sum*1d/k;
        //k+1  window
        for(int i = k; i < nums.length; i++) {
          sum -= nums[left];
          sum += nums[i];
          res = Math.max(res, sum*1d/k);
        }
        return res;
  }
}

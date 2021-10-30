import java.util.*;
//lc891
public class SumOfSubsequenceWidth {
  public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mod = (int)1e9+7;
        long sum = 0;
        long[] pow = new long[n];
        pow[0] = 1;
        for(int i = 1; i < n; i++) {
          pow[i] = (pow[i-1] * 2)%mod;
        }
        for(int i = 0; i < n; i++) {
          sum = (sum + nums[i]*(pow[i]-pow[n-i-1]))%mod;
        }
        return (int) sum;
  }
}

public class SplitSubArray {
  
  public int splitArray(int[] nums, int m) {
        int hi = 0;
        int lo = Integer.MIN_VALUE;
        for(int val : nums) {
          hi += val;
          lo = Math.max(lo, val);
        }
        int ans = Integer.MAX_VALUE;
        while(lo <= hi) {
          int mid = lo + (hi-lo)/2;

          if(isPossible(nums,mid, m)) {
            hi = mid-1;
            ans = mid;
          } else {
            lo = mid+1;
          }
        }
        return ans;
  }

  public boolean isPossible(int[] nums, int mid, int m) {
    //atleast 1 subarr will be there so default val of c is 1
    int c = 1;
    int sum = 0;
    for(int val : nums) {
      if(sum + val > mid) {
        //new subarr if sum exceeds mid
        c++;
        sum = val;
      } else {
        sum+=val;
      }
    }
    return c <= m;
  }
}

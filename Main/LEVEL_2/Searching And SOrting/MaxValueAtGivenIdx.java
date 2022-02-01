class Solution {
  public int maxValue(long n, long index, long maxSum) {
      long lo = 1;
      long hi = maxSum;
      long ans = 0;
      while(lo<= hi) {
        long mid = lo + (hi-lo)/2;
        if(isPossible(mid, n, index, maxSum)) {
          ans = mid;
          lo = mid+1;
        } else {
          hi = mid-1;
        }
      }
      return (int)ans;
  }
  public boolean isPossible(long mid, long n, long index, long maxSum) {
     /**suppose arr[index] = mid = 9 than than other values arr[index+1]
         * and arr[idx-1] will start from 8*/ 
        long st = mid-1;
        //no of elements right and left of index
        long r = n-index-1;
        long l = index;
      /**for st=8 lsum rsum will be like 8+7+6+....n */
      long lsum = 0;
      long rsum = 0;
        if(st >= r) {
          /**Suppose st=8 and there are only 4 slots in right than rsum=
           * 8+7+6+5+4+3+2+1)-(4+3+2+1) in code we will use formula for sum of natural nums
           */
          rsum = st*(st+1)/2 - ((st-r)*(st-r+1)/2);
        } else {
          /**Suppose st = 2 we have 4 slots than,
           * 2+1 [+1 + 1 +1] we need to add 3 extra 1s
           */
          rsum = st*(st+1)/2 + 1*(r-st);
        }

        //for lsum
        if(st >= l) {
          lsum = st*(st+1)/2 - ((st-l)*(st-l+1)/2);
        } else {
          lsum = st*(st+1)/2 + 1*(l-st);
        }
        return lsum+rsum+mid <= maxSum ? true : false;
  }
}
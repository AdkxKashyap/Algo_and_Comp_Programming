class Solution {
  public int findMin(int[] nums) {
       int lo = 0;
      int hi = nums.length-1;
      //edge case - sorted arr
      if(nums[lo] <= nums[hi]) return nums[0];
      if(nums.length == 2) {
          return nums[1];
      }
      while(lo <= hi) {
          int mid = (lo+hi)/2;
          //check mid is min.Use property of min
          if(mid != 0  && nums[mid] < nums[mid-1]) return nums[mid];
          else if(mid != nums.length-1 && nums[mid] > nums[mid+1]) return nums[mid+1];
          else if(nums[lo] <= nums[mid]) {
              //lo to mid part sorted, we will get min in unsorted region 
              lo = mid+1;
          } else {
              //mid to hi sorted
              hi = mid-1;
          }
      }
      return -1;
  }
}
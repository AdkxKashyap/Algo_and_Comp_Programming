//lc - 33
class SearchInRotatedSortedArr {
  public int search(int[] nums, int target) {
    int lo = 0;
    int hi = nums.length-1;
    while(lo <= hi) {
      int mid = lo + (hi-lo)/2;
      if(nums[mid] == target) return mid;
      if(nums[lo] <= nums[mid]) {
        //lo to mid is sorted
        if(target >= nums[lo] && nums[mid] > target) {
          hi = mid-1;
        }else lo = mid+1;
      } else {
        //  mid to hi  is sorted
        if(target > nums[mid] && nums[hi] >= target) {
          lo = mid+1;
        }else hi = mid-1;
      }
    }
    return -1;
  }
}
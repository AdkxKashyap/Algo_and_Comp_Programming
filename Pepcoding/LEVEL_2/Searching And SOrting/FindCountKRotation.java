class Solution {
  //same as find mid in rotated sorted arr
  int findKRotation(int arr[], int n) {
      // code here
       int lo = 0;
      int hi = arr.length-1;
      if(arr[lo] <= arr[hi]) {
          return 0;
      }
      while(lo <= hi) {
          int mid = lo + (hi-lo)/2;
         
          if(mid != 0  && arr[mid] < arr[mid-1]) return mid;
          else if(mid != arr.length-1 && arr[mid] > arr[mid+1]) return mid+1;
          else if(arr[lo] <= arr[mid]) {
              lo = mid+1;
          } else {
              hi = mid-1;
          }
      }
      return 0;
  }
}
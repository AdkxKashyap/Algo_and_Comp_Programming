package Main.LEVEL_2.Arrays_Strings;
class Solution {
  public int[] productExceptSelf(int[] nums) {
      //use this as ans array
      int[] left = new int[nums.length];
      left[0] = 1;
      //create left prod arr
      for(int i = 1; i < nums.length; i++) {
          left[i] = left[i-1] * nums[i-1]; 
      }
      //for right prod
      int right = 1;
      for(int i = nums.length-1; i >= 0; i--) {
          left[i] = right*left[i];
          right = right * nums[i];
      }
      return left;
  }
}
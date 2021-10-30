package Arrays_Funcs;
//lc - 75
//also see segragation ln ll
class Solution {
  public void sortColors(int[] nums) {
      // int i = 0;
      int j = 0;
      int k = 0;
      
      for(int curr = 0; curr < nums.length; curr++) {
          if(nums[curr] == 2) continue;
          else if(nums[curr] == 1) {
              //swap curr and k
              int tmp = nums[k];
              nums[k] = nums[curr];
              nums[curr] = tmp;
              k++;
          }else if(nums[curr] == 0) {
              //swap curr and k
               int tmp = nums[k];
              nums[k] = nums[curr];
              nums[curr] = tmp;
              //swap k and j
              tmp = nums[j];
              nums[j] = nums[k];
              nums[k] = tmp;
              k++;
              j++;
          }
      }
  }
}

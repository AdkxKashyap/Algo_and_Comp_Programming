import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
  public boolean isMajority(int[] nums, int val) {
    int count = 0;
    for(int v : nums) {
      if(v == val) count++;
    }
    return count > nums.length/3;
  }
  public List<Integer> majorityElement(int[] nums) {
        int count1 = 1;
        //val1 and val2 are potential result
        int val1 = nums[0];
        int count2 = 0;
        int val2 = nums[0]; //put any number

        for(int i = 1; i < nums.length; i++) {
          //we need to find triplets
          if(nums[i] == val1) {
            count1++;
          }
          else if(nums[i] == val2) {
            count2++;
          }
          else {
            if(count1 == 0) {
              //assign a new value for triplet
              val1 = nums[i];
              count1 = 1;
            }else if(count2 == 0) {
              //assign a new value for triplet
              val2 = nums[i];
              count2 = 1;
            } else {
              //a triplet is found
              count1--;
              count2--;
            }
          }
        }
        //count freq of val1 and val2
        List<Integer> res = new ArrayList<>();
        if(isMajority(nums,val1)) {
          res.add(val1);
        }
        if(val1 != val2 && isMajority(nums, val2)) {
          res.add(val2);
        }
        return res;
  }
}

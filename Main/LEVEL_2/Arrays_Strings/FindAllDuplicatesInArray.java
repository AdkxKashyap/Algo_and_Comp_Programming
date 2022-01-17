package Main.LEVEL_2.Arrays_Strings;
import java.util.ArrayList;

public class FindAllDuplicatesInArray {
  public List<Integer> findDuplicates(int[] nums) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    for(int i = 0; i < nums.length; i++) {
      int indx = Math.abs(nums[i])-1;
      int val = nums[indx];
      if(val < 0) {
        res.add(Math.abs(nums[i]));
      }else  {
        nums[indx] *= -1;
      }
    }
    return res;  
  }
}

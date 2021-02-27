import java.util.HashMap;
import java.util.Map;

//lc523
//Also see lc560
public class ContSubarraySum {
    //does not work for k=0
    //see https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space for k=0 solution
    //https://www.youtube.com/watch?v=GrV3MTR_Uk0
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<2)return false;
        Map<Integer,Integer>dp=new HashMap<>(){{put(0, -1);}};
        int runningSum=0;
        for(int i=0;i<nums.length;i++){
            runningSum+=nums[i];
            int remainder=0;
            if(dp.containsKey(remainder))return true;
            dp.put(remainder, i);   
        }
        return false;
    }
}

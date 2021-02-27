import java.util.HashMap;
import java.util.Map;

//Combination Sum IV
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=0;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                dp[i]+=i>=nums[j]?dp[i-nums[j]]:0;
            }
        }
        return dp[target];
    }
    //TOP_DOWN 
    // //Array is giving TLE so using maps.If target is large no. like 100000  arrays will take up useless space.
    // public int helper(int[] nums,int target, Map<Integer,Integer> memo){
    //     if(target==0)return 1;
    //     if(target<0)return 0;
    //     if(memo.containsKey(target))return memo.get(target);
    //     int sum=0;
    //     for(int i=0;i<nums.length;i++){
    //         sum+=helper(nums, target-nums[i], memo);
    //     }
    //     memo.put(target, sum);
    //     return sum;
    // }
    // public int combinationSum4(int[] nums, int target) {
    //     Map<Integer,Integer> memo=new HashMap<>();
    //     return helper(nums, target,memo);
    // }
}

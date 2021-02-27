//House Robber
public class HouseRobber {
    
    public int rob(int[] nums) {
        
        if(nums.length<2){
            if(nums.length==0)return 0;
            return nums[0];
        }
        for(int i=2;i<nums.length;i++){
            if(i==2){nums[i]=nums[i]+nums[i-2];continue;}
            nums[i]=Math.max(nums[i]+nums[i-2], nums[i]+nums[i-3]);
        }
        return Math.max(nums[nums.length-1], nums[nums.length-2]);
    }
    
    //TOP-DOWN
    // public int helper(int[] nums,int start,int[] memo){
    //     if(nums[start]==0)return 0;//Getting TLE w/o this.
    //     if(memo[start]!=0)return memo[start];
    //     memo[start]=nums[start];
    //     for(int i=start+2;i<nums.length;i++){
    //         memo[start]=Math.max(memo[start],nums[start]+helper(nums, i, memo));
    //     }
    //     return memo[start];
    // }
    // public int rob(int[] nums) {
    //     int[] memo=new int[nums.length];
    //     int res=0;
    //     for(int i=0;i<nums.length;i++){
    //         res=Math.max(res, helper(nums, i, memo));
    //     }
    //     return res;
    // }
}

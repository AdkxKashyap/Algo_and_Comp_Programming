//55. Jump Game
//https://www.youtube.com/watch?v=muDPTDrpS28
//max reachable can be greater that nums.length
public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReachable=0;
        for(int i=0;i<nums.length;i++){
            if(maxReachable<i)return false;//max reachable should be atleast equal to i,so that we can detect 0 steps.
            maxReachable=Math.max(maxReachable, i+nums[i]);
          
        }
        return true;
    }
}

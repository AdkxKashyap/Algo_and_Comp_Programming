package Main.LEVEL_2.Stacks;
import java.util.Stack;

class Pattern {
  public boolean find132pattern(int[] nums) {
        //create min array
        int n = nums.length;
        int[] min = new int[n];
        int minval = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < minval) {
                  minval = nums[i];
                  min[i] = minval;
            }
        }
        boolean res = false;
        Stack<Integer> stk = new Stack<>();
        for(int j = n-1; j >= 0; j--) {
              while(stk.size() > 0 && min[j] >= stk.peek()) {
                    stk.pop();
              }
              if(stk.size() > 0 && nums[j] > stk.peek()) {
                    res = true;
                    break;
              }
              stk.push(nums[j]);
        }
        return res;
  }
}

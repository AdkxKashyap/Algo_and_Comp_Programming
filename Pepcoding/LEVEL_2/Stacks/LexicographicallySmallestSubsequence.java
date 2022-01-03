import java.util.Stack;
//lc 1673
class Solution {
  public int[] mostCompetitive(int[] nums, int k) {
      Stack<Integer> stk = new Stack<>();
      int n = nums.length;;
      for(int i = 0; i < n; i++) {
        int val = nums[i];
        while(stk.size() > 0 && stk.peek() > val && n-i-1 >= k-stk.size()) {
          stk.pop();
        }
        if(stk.size() < k) {
          stk.push(val);
        }
      }
      int[] res = new int[k];
      int i = k-1;
      while(stk.size() > 0) {
        res[i] = stk.pop();
        i--;
      }
      return res;
  }
}
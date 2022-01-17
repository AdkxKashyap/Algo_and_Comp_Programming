package Main.LEVEL_2.Stacks;
import java.util.Stack;

class TrappingRainwater {
  public int trap(int[] height) {
      int n = height.length;
    Stack<Integer> stk = new Stack<>();
    int res = 0;
    for(int i = 0; i < n; i++) {
      while(stk.size() > 0 && height[stk.peek()] <= height[i]) {
        int rm = i;
        int cur = stk.pop();
        if(stk.size() == 0) break;
        int lm = stk.peek();
        int wd = rm - lm - 1;
        int ht = Math.min(height[rm], height[lm]) - height[cur];
        res += wd*ht;
      }
      stk.push(i);
    }
    return res;
  }
}
import java.util.Stack;

class Solution {
  public int scoreOfParentheses(String s) {
      Stack<Integer> stk = new Stack<>();
      int cur = 0;
      for(int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if(ch == '(') {
          stk.push(cur);
          cur = 0;
        } else {
          cur = stk.pop() + Math.max(2*cur, 1);
        }
      }
      return cur;
  }
}
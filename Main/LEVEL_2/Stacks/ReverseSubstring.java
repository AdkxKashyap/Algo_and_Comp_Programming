package Main.LEVEL_2.Stacks;
import java.util.Stack;

class Solution {
  public String reverseParentheses(String s) {
      Stack<Integer> stk = new Stack<>();
      int[] pair = new int[s.length()];
      for(int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if(ch == '(') stk.push(i);
        else if(ch == ')') {
          int j = stk.pop();
          pair[i] = j;
          pair[j] = i;
        }
      }
      StringBuilder sb = new StringBuilder();
      //d -> to toggle b/w i moving foreward or backward.
      for(int i = 0,  d = 1; i < s.length(); i += d) {
        if(s.charAt(i) == '(' || s.charAt(i) == ')') {
          i = pair[i];
          d = -d;//toggle
        } else {
          sb.append(s.charAt(i));
        }
      }
      return sb.toString();
  }
}
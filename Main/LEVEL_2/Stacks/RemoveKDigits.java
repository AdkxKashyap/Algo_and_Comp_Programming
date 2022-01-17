package Main.LEVEL_2.Stacks;
class Solution {
  public String removeKdigits(String num, int k) {
      Stack<Character> stk = new Stack<>();
      StringBuilder res = new StringBuilder();
      for(int i = 0; i < num.length(); i++) {
          char n = num.charAt(i);
          while(stk.size() > 0 && k > 0 && stk.peek() > n) {
              stk.pop();
              k--;
          }
          stk.push(n);
      }
      //edge case - k > 0 after loop ends. Run {1,2,4, 3,3}
      while(k-- > 0) {
          stk.pop();
      }

      char[] carr = new char[stk.size()];
      int j = stk.size()-1;
      while(j >= 0) {
          carr[j--] = stk.pop(); 
      }
      //remove leading 0s (see leetcode test case)
      int d = 0;
      while(d < carr.length && carr[d] == '0') d++;
      StringBuilder sb = new StringBuilder();
      while(d < carr.length) {
          sb.append(carr[d]);
          d++;
      }
      if(sb.length() == 0) return "0";
      return sb.toString();
  }
}
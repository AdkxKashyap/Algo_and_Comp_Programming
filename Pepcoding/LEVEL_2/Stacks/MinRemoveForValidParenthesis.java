import java.util.Stack;

public class MinRemoveForValidParenthesis {
  public String minRemoveToMakeValid(String s) {
        char[] charr = new char[s.length()];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
          char ch = s.charAt(i);
          if(ch == '(') {
            stk.push(i);
          }
          else if(ch == ')') {
            if(stk.size() == 0) {
              //invalid
              charr[i] = '.';//flag, which denotes that ith pos is invalid
            }
          } else {
            stk.pop();
          }
        }
        while(stk.size() > 0) {
          //extra '(' , Invalid
          charr[stk.pop()] = '.';
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
          if(charr[i] != '.') {
            sb.append(s.charAt(i));
          }
        }
        return sb.toString();
  }
}

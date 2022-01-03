import java.util.Stack;

public class BasicCalculator1 {
  public int calculate(String s) {
        int res = 0;
        int sign = 1;
        Stack<Integer> stk = new Stack<>();
        for( int i = 0; i < s.length(); i++) {
          char ch = s.charAt(i);
          int val = 0;
          if(Character.isDigit(ch)) {
            while(Character.isDigit(s.charAt(i))) {
              val = val*10 + (s.charAt(i)-'0');
              i++;
            }
            //if we dont do this i will be incremented twice.
            i--;
            val *= sign;
            res += val;
            //reset sign
            sign = 1;
          } else if(ch == '-') {
            //'-' always toggles the sign
            sign *= -1;
          } else if(ch == '('){
            //push sign and sum in stack
            stk.push(res);
            stk.push(sign);
            //reset res
            res = 0;
            sign = 1;
          } else if(ch == ')') {
            res *= stk.pop();
            res += stk.pop();
          }
        }
        return res;
  }
}

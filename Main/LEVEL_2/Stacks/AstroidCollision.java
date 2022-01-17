package Main.LEVEL_2.Stacks;
import java.util.Stack;

class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stk = new Stack<>();
    for(int val : asteroids) {
      if(val > 0) {
        //left -> right
        stk.push(val);
      }else {
        //right -> left, 
        while(stk.size() > 0 && stk.peek() > 0 && stk.peek() < Math.abs(val)) {
          stk.pop();
        }
        // check right ast = left ast, In this case both will be destroyed
        if( stk.size() > 0 && stk.peek() == -val) {
          stk.pop();
        }
       else if(stk.size() == 0 || (stk.peek() < 0)) {
         stk.push(val);
       }
      }
    }
    int[] res = new int[stk.size()];
    int i = stk.size()-1;
    while(stk.size() > 0) {
      res[i--] = stk.pop();
    }
    return res;
  }
}
package Main.LEVEL_2.Stacks;
import java.util.Stack;

public class NextGreaterRight {
  public static int[] solve(int[] arr) {
    int n = arr.length;
    int[] res = new int[n];
    Stack<Integer> stk = new Stack<>();
    stk.push(0);
    for(int i = 1; i < n; i++) {
        while(stk.size() > 0 && arr[i] < arr[stk.peek()]) {
            res[stk.pop()] = arr[i];
        }
        stk.push(i);
    }
    while(stk.size() > 0) {
        res[stk.pop()] = -1;
    }
    
    return res;
  }
}

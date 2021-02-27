import java.util.Stack;
//did not understand
public class lc1130 {
    public int mctFromLeafValues(int[] A) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : A) {
            System.out.println(a);
            while (stack.peek() <= a) {
                System.out.println("peeek "+stack.peek());
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[]={6,2,4};
        System.out.println(new lc1130().mctFromLeafValues(arr));
    }
   
}

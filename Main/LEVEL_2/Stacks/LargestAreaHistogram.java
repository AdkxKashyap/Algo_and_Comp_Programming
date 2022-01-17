package Main.LEVEL_2.Stacks;
import java.io.*;
import java.util.*;

public class Main {
    public static int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        Stack<Integer> stk = new Stack();
        //to manage edge case
        stk.push(-1);
        for(int i = 0; i <= heights.length; i++) {
            //manage cases where in the end elements are left out in an array
            int val = i == heights.length ? 0 : heights[i];
            while(stk.peek() != -1 && val <= heights[stk.peek()]) {
                int rm = i;
                int stkval = heights[stk.pop()];
                int lm = stk.peek();
                int wd = stkval * (rm - lm - 1);
                max = Math.max(max, wd);
            }
            stk.push(i);
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int heights[] = new int[n];
        for(int i=0;i<n;i++)heights[i] = Integer.parseInt(read.readLine());

        System.out.println(largestRectangleArea(heights));
        
    }
}

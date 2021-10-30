package Stacks_And_Queues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//Maximal rectangle.Similar to largest area histogram
class MaximalRectangle {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0)
      return 0;
    int[] maxInRow = new int[matrix.length];
    int i = 0;
    for (char[] arr : matrix) {
      int[] nsr = nextSmallestRight(arr);
      int[] nsl = nextSmallestLeft(arr);
      int max = Integer.MIN_VALUE;
      int j = 0;
      while (j < matrix[0].length) {
        max = Math.max(max, (arr[j] - '0') * (nsr[j] - nsl[j] - 1));
        j++;
      }
      maxInRow[i] = max;
      i++;
    }
    int[] nsr = solvenextSmallestRight(maxInRow);
    int[] nsl = solvenextSmallestLeft(maxInRow);
    int max = Integer.MIN_VALUE;
    int j = 0;
    while (j < maxInRow.length) {
      max = Math.max(max, maxInRow[j] * (nsr[j] - nsl[j] - 1));
      j++;
    }

    return max;
  }

  // for integer array
  public static int[] solvenextSmallestLeft(int[] arr) {
    int[] res = new int[arr.length];
    Stack<Integer> stk = new Stack<>();
    stk.push(arr.length - 1);
    for (int i = arr.length - 2; i >= 0; i--) {
      while (stk.size() > 0 && arr[i] < arr[stk.peek()]) {
        res[stk.pop()] = i;
      }
      stk.push(i);
    }
    while (stk.size() > 0) {
      res[stk.pop()] = -1;
    }
    return res;
  }

  public static int[] solvenextSmallestRight(int[] arr) {
    int[] res = new int[arr.length];
    Stack<Integer> stk = new Stack<>();
    stk.push(0);
    for (int i = 1; i < arr.length; i++) {
      while (stk.size() > 0 && arr[i] < arr[stk.peek()]) {
        res[stk.pop()] = i;
      }
      stk.push(i);
    }
    while (stk.size() > 0) {
      res[stk.pop()] = arr.length;
    }
    return res;
  }

  /** This is for character array */
  public int[] nextSmallestRight(char[] arr) {
    Stack<Integer> stk = new Stack<>();
    int[] nsr = new int[arr.length];
    stk.push(0);
    for (int i = 1; i < arr.length; i++) {
      while (stk.size() > 0 && arr[stk.peek()] > arr[i]) {
        nsr[stk.pop()] = i;
      }
      stk.push(i);
    }
    while (stk.size() > 0) {
      nsr[stk.pop()] = arr.length;
    }
    return nsr;
  }

  public int[] nextSmallestLeft(char[] arr) {
    Stack<Integer> stk = new Stack<>();
    int[] nsl = new int[arr.length];
    stk.push(arr.length - 1);
    for (int i = arr.length - 2; i >= 0; i--) {
      while (stk.size() > 0 && arr[i] < arr[stk.peek()]) {
        nsl[stk.pop()] = i;
      }
      stk.push(i);
    }
    while (stk.size() > 0) {
      nsl[stk.pop()] = -1;
    }
    return nsl;
  }

  public static void main(String[] args) {
    char[][] arr = { { '1', '0', '1', '0', '0' }, { '0', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
        { '1', '0', '0', '1', '0' } };
    MaximalRectangle mr = new MaximalRectangle();
    int res = mr.maximalRectangle(arr);
    System.out.println(res);
  }
}

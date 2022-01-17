package Main.Stacks_And_Queues;

import java.io.*;
import java .util.*;


public class MinimumStack1b {
  public static class MinStack {
    Stack<Integer> allData;
    int min;

    public MinStack() {
      allData = new Stack<>();
      min=Integer.MAX_VALUE;
    }

    int size() {
      // write your code here
      return allData.size();
    }

    void push(int val) {
      // write your code here
     if(min>val){
       //create a new min,if val < curr min
       int newval=2*val-min;
        allData.push(newval);
        min=val;
     }
     else allData.push(val); 
    }

    int pop() {
      // write your code here
      if(allData.peek()<min){
        int val=min;
        min=2*min-allData.pop();
       
        return val;
      }
      else return allData.pop();
    }

    int top() {
      // write your code here
      if (allData.peek() < min) {
        return min;
      } else
        return allData.peek();
    }

    int min() {
      // write your code here
      return min;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}

package Main.Stacks_And_Queues.Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//remove efficient
public class StackToQueue2 {
  public static class StackToQueueAdapter {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapter() {
      mainS = new Stack<>();
      helperS = new Stack<>();
    }

    int size() {
      // write your code here
      return mainS.size();
    }

    void add(int val) {
      // write your code here
      while (mainS.size() > 0) {
        helperS.push(mainS.pop());
      }
      mainS.add(val);
      while (helperS.size() > 0) {
        mainS.push(helperS.pop());
      }
    }

    int remove() {
      // write your code here
      // from main->helper

      return mainS.pop();
    }

    int peek() {
      // write your code here
      // from main->helper

      return mainS.peek();
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StackToQueueAdapter qu = new StackToQueueAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}

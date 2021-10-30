package Stacks_And_Queues.Queue;

import java.util.*;

//question->https://practice.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1#
//Optimize O(N)
public class GenerateBinaryNumbers {
  static ArrayList<String> generate(int N) {
    // Your code here
    ArrayList<String> res = new ArrayList<String>();
    Queue<String> que = new ArrayDeque<>();
    que.add("1");
    for (int i = 0; i < N; i++) {
      String str = que.poll();
      que.add(str + "0");
      que.add(str + "1");
      res.add(str);
    }
    return res;
  }
}

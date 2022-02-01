import java.util.*;
import java.io.*;

public class Main {

  static class Pair implements Comparable<Pair> {
    int val;
    int idx;
    Pair(int val, int idx) {
      this.val = val;
      this.idx = idx;
    }
    @Override
    public int compareTo(Pair o) {
      // TODO Auto-generated method stub
      if(this.val != o.val) {
          return this.val-o.val;
      } else {
          //added this because if two val are same we need to print values in order of their occurance
          return o.idx-this.idx;
      }
      
    }
  
  }
  public static int[] kToppers(int[]marks, int k) {
    //write your code here
    int[] res = new int[k];
    PriorityQueue<Pair> pq= new PriorityQueue<>();
    for(int i = 0; i < marks.length; i++) {
      if(pq.size() >= k) {
        if(pq.peek().val < marks[i]) {
          pq.poll();
          pq.add(new Pair(marks[i], i));
        } 
      }else {
          pq.add(new Pair(marks[i], i));
        }
    }
    //since this is a min queue we need to add in res from last;
    int j = k-1;
    while(pq.size() > 0) {
      res[j--] = pq.poll().idx;
    }
    return res;
  }
  
  
  public static void main(String[]args) {

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]marks = new int[n];

    for (int i = 0; i < n; i++) {
      marks[i] = scn.nextInt();
    }

    int k = scn.nextInt();

    int[]ans = kToppers(marks, k);

    for (int i = 0; i < ans.length; i++) {
      System.out.print(ans[i] + " ");
    }

  }
}
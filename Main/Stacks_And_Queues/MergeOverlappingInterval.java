package Main.Stacks_And_Queues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

import java.io.*;

public class MergeOverlappingInterval {
  public static class Pair implements Comparable<Pair> {
    int st;
    int end;

    Pair(int st, int end) {
      this.st = st;
      this.end = end;
    }

    @Override
    public int compareTo(Pair o) {
      // TODO Auto-generated method stub
      return this.st - o.st;
    }
  }

  public static void main(String[] args) throws Exception {
    // write your code here
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][2];

    for (int j = 0; j < n; j++) {
      String line = br.readLine();
      arr[j][0] = Integer.parseInt(line.split(" ")[0]);
      arr[j][1] = Integer.parseInt(line.split(" ")[1]);
    }

    mergeOverlappingIntervals(arr);
  }

  public static void mergeOverlappingIntervals(int[][] arr) {
    // merge overlapping intervals and print in increasing order of start time
    Pair[] p = new Pair[arr.length];
    for (int i = 0; i < arr.length; i++) {
      Pair np = new Pair(arr[i][0], arr[i][1]);
      p[i] = np;
    }
    Arrays.sort(p);
    Stack<Pair> stk = new Stack<>();
    stk.push(p[0]);
    for (int i = 1; i < p.length; i++) {
      Pair tmp = stk.peek();
      if(p[i].st <= tmp.end){
        if(p[i].end > tmp.end){
          tmp.end = p[i].end;
        }
      }
      else stk.push(p[i]);
    }

    //this is to display the results according to pepcodeing question
    Stack<Pair> tmp = new Stack<>();
    while(stk.size() != 0){
      tmp.push(stk.pop());
    }
    while(tmp.size() !=  0){
      Pair res = tmp.pop();
      System.out.println(res.st + " " + res.end);
    }
  }
}

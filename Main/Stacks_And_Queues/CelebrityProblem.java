package Main.Stacks_And_Queues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.*;

public class CelebrityProblem {
  public static void main(String[] args) throws Exception {
    // write your code here
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for (int j = 0; j < n; j++) {
      String line = br.readLine();
      for (int k = 0; k < n; k++) {
        arr[j][k] = line.charAt(k) - '0';
      }
    }

    findCelebrity(arr);

  }

  public static void findCelebrity(int[][] arr) {
    // if a celebrity is there print it's index (not position), if there is not then
    // print "none"
    Stack<Integer>stk=new Stack<>();
    for(int i=0;i<arr.length;i++){
      stk.push(i);
    }
    while(stk.size()>1){
      int potCand1=stk.pop();
      int potCand2=stk.pop();
      if(arr[potCand1][potCand2]==1)stk.push(potCand2);
      else stk.push(potCand1);
    }
    //might not be a celebrity
    int potCand=stk.pop();
    //check pot cand row for all arr[i][potCand]=1
    for(int i=0;i<arr.length;i++){
      if(i!=potCand && arr[i][potCand]!=1){
        System.out.println("none");
        return;
      }
    }
    // check pot cand row for all arr[i][potCand]=1
    for (int j = 0; j < arr.length; j++) {
      if (j != potCand && arr[potCand][j] != 0 && arr[j][potCand] == 0) {
        System.out.println("none");
        return;
      }
    }
    System.out.println(potCand);
  }

}

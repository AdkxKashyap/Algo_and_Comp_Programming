package Stacks_And_Queues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SmallestNumberFollowingPattern {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // code
    printSequence(str);
  }

  public static void printSequence(String str){
    Stack<Integer>stk=new Stack<>();
    int count=1;
    stk.push(count);
    for(int i=0;i<str.length();i++){
      char ch=str.charAt(i);
      if(ch=='d'){
        count++;
        stk.push(count);
      }
      else{
        count++;
        while(stk.size()>0){
          System.out.print(stk.pop());
        }
        stk.push(count);
      }
    }
    while(stk.size()>0){
      System.out.print(stk.pop());
    }
  }
}

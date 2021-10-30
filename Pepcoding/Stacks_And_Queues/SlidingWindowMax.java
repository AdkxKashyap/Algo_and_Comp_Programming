package Stacks_And_Queues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SlidingWindowMax {
  public static void main(String[] args) throws Exception {
    Scanner scanner=new Scanner(System.in);

    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    int k = scanner.nextInt();

    // code
    printMax(a,k);
  }
  public static void printMax(int[] arr,int k ){
    int[] ngr=nxtGreatElem(arr);
    int j=0;
    for(int i=0;i<=arr.length-k;i++){
      if(i>j)j=i;

      while(ngr[j]<i+k){
        j=ngr[j];
      }
      System.out.println(arr[j]);
    }
  }
  public static int[] nxtGreatElem(int[] arr) {
    int[] res=new int[arr.length];
    Stack<Integer> stk=new Stack<>();
    stk.push(0);
    for(int i=1;i<arr.length;i++){
      while(stk.size()>0 && arr[stk.peek()]<arr[i]){
        res[stk.pop()]=i;
      }
      stk.push(i);
    }
    while(stk.size()>0){
      res[stk.pop()]=arr.length;
    }
    return res;
  }
}

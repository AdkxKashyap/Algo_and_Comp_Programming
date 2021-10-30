import java.io.*;
import java.util.*;

public class LargestAreaHistogram {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    // code
    int area=findLargestArea(a);
  }

  public static int findLargestArea(int arr[]){
    int[] nsl = nextSmallerLeft(arr);
    int[] nsr = nextSmallerRight(arr);
    int res=Integer.MIN_VALUE;
    for(int i=0;i<arr.length;i++){
      res=Math.max(res, (nsr[i]-nsl[i]-1)*arr[i]);
    }
    return res;
  }

  public  int[] nextSmallerLeft(int[] arr){
    int[] res=new int[arr.length];
    Stack<Integer> stk=new Stack<>();
    stk.push(arr.length-1);
    for(int i=arr.length-2;i>=0;i--){
      while(stk.size()>0 && arr[i]<arr[stk.peek()]){
        res[stk.pop()]=i;
      }
      stk.push(i);
    }
    while(stk.size()>0){
      res[stk.pop()]=-1;
    }
    return res;
  }

  public int[] nextSmallerRight(int[] arr) {
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
}
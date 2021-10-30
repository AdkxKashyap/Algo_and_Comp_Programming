import java.io.*;
import java.util.*;
//Used linked list instead of stack
public class StockSpan2{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
   // solve
   List<Integer> lst = new LinkedList<Integer>();
   int n = arr.length;
   int[] res = new int[n];
   lst.add(n-1);
   for(int i = n-2; i >= 0; i--) {
       int val = arr[i];
       Iterator itr = lst.iterator();
      while(itr.hasNext()) {
          int idx = (Integer)itr.next();
           if(arr[i] > arr[idx]) {
               res[idx] = idx - i;
               itr.remove();
           }else {
               break;
           }
       }
       lst.add(0, i);
   }
   for(int idx : lst) {
       res[idx] = idx - (-1);
   }
   return res;
 }

}
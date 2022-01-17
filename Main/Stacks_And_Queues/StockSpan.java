package Main.Stacks_And_Queues;
import java.util.Stack;

public class StockSpan {
  public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
  }

  public static int[] solve(int[] arr) {
    int[] res=new int[arr.length];
    Stack<Integer> stk=new Stack<>();
    stk.push(arr.length-1)
    for(int i=arr.length-2;i>=0;i--){
      while(stk.size()>0 && arr[stk.peek()]<arr[i]){
        res[stk.peek()]=stk.peek()-i;
        stk.pop();
      }
      stk.push(i);
    }
    while(stk.size()>0){
      res[stk.peek()]=stk.peek()+1;
      stk.pop();
    }
    return res;
  }
}

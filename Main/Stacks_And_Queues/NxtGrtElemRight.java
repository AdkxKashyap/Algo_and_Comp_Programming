package Main.Stacks_And_Queues;
import java.util.Stack;
//Also see nXt Great elem left
//Also see nXt Small elem left
//Also see nXt Small elem right
public class NxtGrtElemRight {
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

    int[] nge = solve(a);
    display(nge);
  }

  public static int[] solve(int[] arr) {
    int[] res=new int[arr.length];
    Stack<Integer> stk=new Stack<>();
    stk.push(0)
    for(int i=1;i<arr.length;i++){
      while(stk.size()>0 && arr[stk.peek()]<arr[i]){
        res[stk.pop()]=arr[i];
      }
      stk.push(i);
    }
    while(stk.size()>0){
      res[stk.pop()]=-1;
    }
    return res;
  }
}

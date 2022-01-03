import java.util.*;

public class Main {

    public static int solution(int[] arr, int k) {
        // write your code here
        int sum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < arr.length ; i++) {
          int val = arr[i];
          sum += val;
          int mod = sum % k;
          if(mod < 0) {
            mod += k;
          }
          if(map.containsKey(mod)) {
            int idx = map.get(mod);
            max = Math.max(max, i-idx);
          }
          map.putIfAbsent(mod, i);
        }
        return max;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}

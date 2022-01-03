import java.util.*;

public class Main {
    //similar to largest subarr with 0 and 1.
    public static int solution(int[] arr) {
        // write your code here
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int count = 0;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == 0)
            sum += -1;
        else
            sum += 1;

        if(map.containsKey(sum)) {
          //keep a count 
            count += map.get(sum);
            map.put(sum, map.get(sum)+1);
        }else {
            map.put(sum, 1);    
        }
        
  }
  return count;
        
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}

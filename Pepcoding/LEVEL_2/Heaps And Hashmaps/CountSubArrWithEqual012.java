import java.util.HashMap;

public class CountSubArrWithEqual012 {
  public static int solution(int[] arr) {
    // write your code here
    int c0 = 0;
    int c1 = 0;
    int c2 = 0;
    int count = 0;
    HashMap<String, Integer> map = new HashMap<>();
    
    String key = (c1-c0) + "#" + (c2-c1);
    map.put(key, 1);
    for (int val : arr) {
      if (val == 0)
        c0++;
      else if (val == 1)
        c1++;
      else
        c2++;

     
      key = (c1-c0) + "#" + (c2-c1);
      if (map.containsKey(key)) {
        count += map.get(key);
        map.put(key, map.get(key)+1);
      } else {
        map.put(key, 1);
      }
    }
    return count;
  }
}

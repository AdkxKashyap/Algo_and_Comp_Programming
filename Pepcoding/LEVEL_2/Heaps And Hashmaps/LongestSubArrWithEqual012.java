import java.util.HashMap;

public class LongestSubArrWithEqual012 {
  public static int solution(int[] arr) {
    // write your code here
    int count_0 = 0;
    int count_1 = 0;
    int count_2 = 0;
    int res = 0;
    HashMap<String, Integer> map = new HashMap<>();
    int delta_10 = count_1 - count_0;
    int delta_21 = count_2 - count_1;
    String key = delta_10 + "#" + delta_21;
    map.put(key, -1);
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      if (val == 0)
        count_0++;
      if (val == 1)
        count_1++;
      else
        count_2++;

      delta_10 = count_1 - count_0;
      delta_21 = count_2 - count_1;
      key = delta_10 + "#" + delta_21;
      if (map.containsKey(key)) {
        int idx = map.get(key);
        res = Math.max(res, i - idx);
      } else {
        map.put(key, i);
      }
    }
    return res;
  }
}

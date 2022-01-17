import java.util.HashMap;

public class CountSubarrayDivByK {
  public static int solution(int[] arr, int k) {
    // write your code here
    int sum = 0;
    int count = 0;
    // use arrays instead of map. ** see below
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      sum += val;
      int mod = sum % k;
      if (mod < 0) {
        mod += k;
      }
      if (map.containsKey(mod)) {
        count += map.get(mod);
        map.put(mod, map.get(mod) + 1);
      }
      map.putIfAbsent(mod, 1);
    }
    return count;
  }

  public static int solution2(int[] arr, int k) {
    int sum = 0;
    int count = 0;
    int[] map = new int[k];// arr to store remainders. it will always be less than K
    map[0] = 1;
    for (int val : arr) {
      sum += val;
      int mod = sum % k;
      if (mod < 0) {
        mod += k;
      }
      count += map[mod];
      map[mod]++;
    }
    return count;
  }
}

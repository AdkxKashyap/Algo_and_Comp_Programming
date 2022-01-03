import java.util.*;

class Solution {

  // Function for finding maximum and value pair
  public static int lenOfLongSubarr(int A[], int N, int K) {
    // Complete the function
    HashMap<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int max = 0;
    map.put(0, -1);
    for (int i = 0; i < N; i++) {
      sum += A[i];
      if (map.containsKey(sum - K)) {
        max = Math.max(max, i - map.get(sum - K));
      } 
      //sum might already be present, in that case dont update idx
        map.putIfAbsent(sum, i);
    }
    return max;
  }

}

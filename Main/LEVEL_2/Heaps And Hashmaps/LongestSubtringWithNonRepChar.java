public class LongestSubtringWithNonRepChar {
  // solution -
  // https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
  public static int solution(String str) {
    // write your code here
    int[] map = new int[128];
    int start = 0;
    int end = 0;
    int res = Integer.MIN_VALUE;
    boolean flag = false;
    for (char ch : str.toCharArray()) {

      // acquire
      if (map[ch] > 0)
        flag = true;
      map[ch]++;
      end++;

      while (start < end && flag) {
        // release
        char cc = str.charAt(start);
        start++;
        map[cc]--;
        if (map[cc] == 1)
          flag = false;
      }

      res = Math.max(res, end - start);
    }
    return res == Integer.MIN_VALUE ? 0 : res;
  }
}

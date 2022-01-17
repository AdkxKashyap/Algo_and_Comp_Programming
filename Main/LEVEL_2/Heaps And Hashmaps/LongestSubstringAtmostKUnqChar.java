public class LongestSubstringAtmostKUnqChar {
  public static int solution(String str, int k) {
		// write your code here
		int[] map = new int[128];
    int start = 0;
    int end = 0;
    int res = Integer.MIN_VALUE;
    int count = 0;
    for (char ch : str.toCharArray()) {

      // acquire
      if (map[ch] == 0)
        count++;
      map[ch]++;
      end++;

      while (count > k) {
        // release
        char cc = str.charAt(start);
        start++;
        map[cc]--;
        if (map[cc] == 0)
          count--;
      }

      res = Math.max(end - start, res);

    }
    return res == Integer.MIN_VALUE ? 0 : res;
	}
}

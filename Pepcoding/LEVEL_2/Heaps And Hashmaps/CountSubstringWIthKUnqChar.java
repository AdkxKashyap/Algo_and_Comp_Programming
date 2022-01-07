public class CountSubstringWIthKUnqChar {
  long substrCount(String str, int k) {
    // your code here
    int[] map = new int[128];
    int start = 0;
    long res = Integer.MIN_VALUE;
    int count = 0;
    for (char ch : str.toCharArray()) {

      // acquire
      if (map[ch] == 0)
        count++;
      map[ch]++;
      while (count > k) {
        // release

        char cc = str.charAt(start);
        start++;
        map[cc]--;
        if (map[cc] == 0)
          count--;
      }
      res++;
    }
    return res;
  }
}

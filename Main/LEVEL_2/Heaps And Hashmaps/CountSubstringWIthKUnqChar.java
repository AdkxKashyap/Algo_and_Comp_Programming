public class CountSubstringWIthKUnqChar {
  long substrCount(String str, int k) {
    // your code here
    int[] map = new int[128];
    int start = 0;
    int end = 0;
    int res = 0;
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
        if(count == k)
          res += end-start;
      
    }
    return res == Integer.MIN_VALUE ? 0 : res;
  }
}

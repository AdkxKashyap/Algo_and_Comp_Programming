import java.util.*;

//Minimum window substring lc - 76
public class Main {
  // this solution uses hmap
  public static String solution(String s1, String s2) {
    // write your code here
    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();
    String ans = "";
    for (char ch : s2.toCharArray()) {
      map2.put(ch, map2.getOrDefault(ch, 0) + 1);
    }
    int chCnt = 0;
    int i = 0;
    int j = 0;
    while (true) {
      boolean f1 = false;
      boolean f2 = false;
      // aquire phase
      while (i < s1.length() && chCnt < s2.length()) {

        char ch = s1.charAt(i);
        i++;
        map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        // if the aquired ch contributes to the substring incr count
        if (map1.get(ch) <= map2.getOrDefault(ch, 0)) {
          chCnt++;
        }
        f1 = true;
      }
      // release phase
      while (j < i && chCnt == s2.length()) {

        // potential ans
        // since i start from 0 dont do i+1
        String pans = s1.substring(j, i);
        if (ans.length() == 0 || pans.length() < ans.length()) {
          ans = pans;
        }

        char cc = s1.charAt(j);
        j++;
        int freq = map1.get(cc);
        if (freq == 1) {
          map1.remove(cc);
        } else
          map1.put(cc, freq - 1);

        // if a significant ch is remove decrement count
        if (map1.getOrDefault(cc, 0) < map2.getOrDefault(cc, 0)) {
          chCnt--;
        }
        f2 = true;
      }
      // if control doesnt enter both aquire and release phase
      if (!f1 && !f2)
        break;
    }

    return ans;
  }

  // using array -> less time ** IMP Approach
  public static String Solution2(String s1, String s2) {
    /**
     * Similar to the above solution. Here we are using arr instead of hmap.
     * 1. Use two pointers: start and end to represent a window.
     * 2. Move end to find a valid window.
     * 3. When a valid window is found, move start to find a smaller window.
     */
    // ascii of z = 122. so 98 to 123
    int[] map = new int[128];
    for (char ch : s2.toCharArray()) {
      map[ch]++;
    }
    int start = 0;
    int end = 0;
    int minStart = 0;
    int minLen = Integer.MAX_VALUE;
    // int maxlen = Integer.MAX_VALUE;
    int chCount = 0;
    while (end < s1.length()) {
      // aquire phase
      char ch = s1.charAt(end);
      end++;
      if (map[ch] > 0) {
        chCount++;
      }
      map[ch]--;

      // release phase
      while (chCount == s2.length()) {
        // curr length of substr < maxlength update
        if (minLen > end - start) {
          minLen = end - start;
          minStart = start;
        }
        char cc = s2.charAt(start);
        start++;
        map[cc]++;
        if (map[cc] > 0) {
          chCount--;
        }
      }
    }
    return minLen == Integer.MAX_VALUE ? "" : s1.substring(minStart, minLen + minStart);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.next();
    String s2 = scn.next();
    System.out.println(solution(s1, s2));
  }
}

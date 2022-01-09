import java.util.*;

public class FindAllAnagrams {
  public boolean compare(HashMap<Character, Integer> smap, HashMap<Character, Integer> pmap) {
    for(char ch : pmap.keySet()) {
      if(smap.get(ch) != pmap.get(ch)) return false;
    }
    return true;
  }
  public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();
        List<Integer> lst = new ArrayList<>();
        if(p.length() > s.length()) return lst;
        for(int i = 0; i < p.length(); i++) {
          pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0)+1);
        }
        for(int j = 0; j < p.length(); j++) {
          smap.put(s.charAt(j), smap.getOrDefault(s.charAt(j), 0)+1);
        }
        int i = p.length();
        int j = 0;
        while(i < s.length()) {
          if(compare(smap, pmap)) {
            lst.add(j);
          }
          //acquire
          smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i),0)+1);
          //release
          smap.put(s.charAt(j), smap.get(s.charAt(j))-1);
          i++;
          j++;
        }
        //for the last window
        if(compare(smap, pmap)) {
          lst.add(j);
        }
        return lst;
  }

  //leetcode - 438 solution
  public List<Integer> findAnagrams(String s, String p) {
    int[] hash = new int[256];
    for(char ch : p.toCharArray()) {
        hash[ch]++;
    }
    List<Integer> res = new ArrayList<>();
    int left = 0;
    int right = 0;
    int count = p.length();
    while(right < s.length()) {
        //acquire
        if(hash[s.charAt(right)] >= 1) {
                count--;
            };
        hash[s.charAt(right)]--;
        right++;
        
        if(count == 0) res.add(left);
        
        //release
       if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)                 count++;
    }
    return res;
}
}

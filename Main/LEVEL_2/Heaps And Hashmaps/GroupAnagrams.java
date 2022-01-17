import java.util.*;
public class GroupAnagrams {
  /**using char array solution(leetcode solution - https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution/241458). 
   * We can also use map - see pep solution
  */
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();

    for(String str : strs) {
      char[] cmap = new char[26];
      for(int i = 0; i < str.length(); i++) {
        //strings which are anagrams will have the same cmap
        cmap[str.charAt(i )-'a']++;
      }
      //same key for anagrams. key -> str
      String key = new String(cmap);
      List<String>lst = map.getOrDefault(key, new ArrayList<>());
      lst.add(str);
      map.put(key, lst);
    }
    return new LinkedList<>(map.values());
  }
}

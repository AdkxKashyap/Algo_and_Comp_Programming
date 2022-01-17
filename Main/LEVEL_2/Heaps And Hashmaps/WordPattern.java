import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
  public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if(pattern.length() != strs.length) return false;
        //char -> string
        HashMap<Character, String> hmap = new HashMap<>();
        HashSet<String> used = new HashSet<>();
        for(int i = 0; i < pattern.length(); i++) {
          char ch = pattern.charAt(i);
          String str = strs[i];
          //check if char exists
          if(hmap.containsKey(ch)) {
            if(!hmap.get(ch).equals(str)) return false;
          } else {
            if(used.contains(str)) return false;

            hmap.put(ch, str);
            used.add(str);

          }
        }
        return true;
  }
}

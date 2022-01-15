import java.util.*;
public class IsomorphicStrings {
  public boolean isIsomorphic(String s, String t) {
        if(s.length() > t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> used = new HashSet<>();

        for(int i = 0; i < s.length();i++) {
          char c1 = s.charAt(i);
          char c2 = t.charAt(i);

          //chaeck if c1 is present and is mapped to some other char
          if(map.containsKey(c1)) {
            if(c2 != map.get(c1))return false;
          } else {
            //check is c2 is alread used. see notes eg 3
            if(used.contains(c2)) return false;
            map.put(c1, c2);
          }
        }
        return true;
  }
}

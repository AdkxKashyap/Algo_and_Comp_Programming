import java.util.*;
public class GroupShiftedStrings {
  public static List<List<String>> groupStrings(String[] strings) {
    // write your code here.
    HashMap<String, List<String>>map = new HashMap<>();
    for(String s : strings) {
      String key = getKey(s);
      List<String> lst = map.getOrDefault(key, new ArrayList<>());
      lst.add(s);
      map.put(key, lst);
    }
    return new ArrayList<>(map.values());
  }
  /**key is diff b/w each char
   * eg abe - 1#3
   *    eg 2 dac - 23#2
  */
  public static String getKey(String str) {
    String key = "";
    for(int i = 1; i < str.length(); i++) {
      int diff  = str.charAt(i)-str.charAt(i-1);
      if(diff < 0) {
        //in case of eg 2
        diff+=26;
      }
      key+=diff + "#";
    }
    return key;
  }
}

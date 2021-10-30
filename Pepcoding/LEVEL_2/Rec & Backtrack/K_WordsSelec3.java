import java.util.*;

public class K_WordsSelec3 {
  //duplicates allowed
  public static void combo(String ustr, int cur, HashMap<Character, Integer>fmap, String asf, int k) {
    if(asf.length() == k) {
      System.out.println(asf);
      return;
    }
    if(cur == ustr.length()) return;
    char ch = ustr.charAt(cur);
    int freq = fmap.get(ch);
    for(int i = freq; i > 0; i--) {
      String str = "";
      for(int j = 0; j < i; j++) {
        str += ch;
      }
      if(asf.length() + i <= k) {
        combo(ustr, cur + 1, fmap, asf + str, k);
      }
    }
    combo(ustr, cur + 1, fmap, asf, k);
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    int k = sc.nextInt();
    String ustr = "";
    HashSet<Character> hs = new HashSet<>();
    HashMap<Character, Integer> fmap = new HashMap<>();
    for(int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if(hs.contains(ch) == false) {
        hs.add(ch);
        ustr += ch;
        fmap.put(ch, 1);
      }
      else {
        fmap.put(ch, fmap.get(ch) + 1);
      }
    }
    combo(ustr, 0, fmap, "", k);
  }
}

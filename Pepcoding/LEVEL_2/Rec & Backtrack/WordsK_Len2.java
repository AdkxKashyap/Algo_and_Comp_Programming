import java.io.*;
import java.util.*;

public class WordsK_Len2 {
  /**level -> box, options -> items
   * cs - cur slot, ts - total slots **/
  public static void find(String ustr, HashSet<Character> visited, int cs, int ts, String asf) {
    if(cs == ts) {
      System.out.println(asf);
      return;
    }
    for(int c = 0; c < ustr.length(); c++) {
      char ch = ustr.charAt(c);
      if(visited.contains(ch) == false) {
        visited.add(ch);
        find(ustr, visited, cs + 1, ts, asf + ch);
        visited.remove(ch);
      }
    }
  }
 
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }
    find(ustr, new HashSet<>(), 0, k, "");
  }
}
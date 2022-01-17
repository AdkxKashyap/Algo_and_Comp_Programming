import java.io.*;
import java.util.*;

public class WordsK_Len4 {

 public static void find(String ustr, int ssf, int ts, String asf, HashMap<Character, Integer> fmap) {
  if(ssf == ts) {
    System.out.println(asf);
    return;
  }
  for(int i = 0; i < ustr.length(); i++) {
    char ch = ustr.charAt(i);
    int freq = fmap.get(ch);
    if(freq > 0) {
      fmap.put(ch, freq - 1);
      find(ustr, ssf + 1, ts, asf + ch, fmap);
      fmap.put(ch, freq);
    }
  }
 }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

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
    find(ustr, 0, k, "", fmap);
  }
}
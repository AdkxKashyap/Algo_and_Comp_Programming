import java.io.*;
import java.util.*;

public class WordsK_Len3 {

  /**lao - last occurance of character, cc - current char, ssf -string so far 
   * Duplicates Allowed**/
  public static void find(String str, int cc, int ssf, int ts,  HashMap<Character, Integer> lao, Character[] slots) {
    if(cc == str.length()) {
      if(ssf == ts) {
        for(int i = 0; i < ts; i++) {
            System.out.print(slots[i]);
        }
         System.out.println();
      }
      return;
    }
    char ch = str.charAt(cc);
    int lstO = lao.get(ch);
    //yes call
    for(int i = lstO + 1; i < ts; i++) {
      if(slots[i] == null) {
        slots[i] = ch;
        lao.put(ch, i);
        find(str, cc + 1, ssf + 1, ts, lao, slots);
        slots[i] = null;
        lao.put(ch, lstO);
      }
    }
    //no call only when previously this char is not used.If not done duplicates will come
    if(lao.get(ch) == -1)
        find(str, cc + 1, ssf, ts, lao, slots);

  }
 

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    HashMap<Character, Integer> hm = new HashMap<>();
    int k = Integer.parseInt(br.readLine());
    for(char ch : str.toCharArray()) {
      hm.put(ch, -1);
    }
    find(str, 0, 0, k, hm, new Character[k]);
  }

}
import java.io.*;
import java.util.*;
/**This is permutation. Also see KWords select,whic is combination 
 * Duplicates Not Allowed
 * level - char, options = box**/
public class WordsK_Len1 {

 //
    public static void find(String ustr, Character[] slots, int ssf, int i) {
        
        if(i == ustr.length()) {
            if(ssf == slots.length) {
                for(int s = 0; s < slots.length; s++) {
                    System.out.print(slots[s]);
                }
                System.out.println();
            }
            
            return;
        }
        char ch = ustr.charAt(i);
        //yes call
        for(int s = 0; s < slots.length; s++) {
            if(slots[s] == null) {
                slots[s] = ch;
                find(ustr, slots, ssf + 1, i + 1);
                slots[s] = null;
            }
        }
        //no call
        find(ustr, slots, ssf, i + 1);
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
    find(ustr, new Character[k], 0, 0);
    
  }

}
import java.io.*;
import java.util.*;

public class Cryptarithmetic {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();

    HashMap<Character, Integer> charIntMap = new HashMap<>();
    String unique = "";
    for (int i = 0; i < s1.length(); i++) {
      if (!charIntMap.containsKey(s1.charAt(i))) {
        charIntMap.put(s1.charAt(i), -1);
        unique += s1.charAt(i);
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      if (!charIntMap.containsKey(s2.charAt(i))) {
        charIntMap.put(s2.charAt(i), -1);
        unique += s2.charAt(i);
      }
    }

    for (int i = 0; i < s3.length(); i++) {
      if (!charIntMap.containsKey(s3.charAt(i))) {
        charIntMap.put(s3.charAt(i), -1);
        unique += s3.charAt(i);
      }
    }

    boolean[] usedNumbers = new boolean[10];
    solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
  }

  public static int sumStr(String str, HashMap<Character, Integer> charIntMap) {
    /**eg a- 5 , b - 2, c - 3 
     * return 523 , not sum 10
     */
    String sum = "";
    for(int i = 0; i < str.length(); i++) {
      sum += charIntMap.get(str.charAt(i));
    }
    return Integer.parseInt(sum);
  }
  public static void solution(String unique, int idx, 
							  HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, 
							  String s1, String s2, String s3) {
	    // write your code here
	    if(idx == unique.length()) {
        int n1 = sumStr(s1, charIntMap);
        int n2 = sumStr(s2, charIntMap);
        int n3 = sumStr(s3, charIntMap);
        if(n1 + n2 == n3) {
          //print in sorted way
          for(int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            if(charIntMap.containsKey(ch)) {
              System.out.print(ch + "-" + charIntMap.get(ch) + " ");
            }
          }
          System.out.println();
        }
        return;
      }
      char ch = unique.charAt(idx);
      for(int i = 0; i < 10; i++) {
        if(usedNumbers[i] == false) {
          usedNumbers[i] = true;
          charIntMap.put(ch, i);
          solution(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
          usedNumbers[i] = false;
          charIntMap.put(ch, -1);
        }
      }
  }

}

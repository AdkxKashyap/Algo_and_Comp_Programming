package Hashmaps;

import java.util.*;
public class HighestFreqCount {
  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    HashMap<Character, Integer> hm = new HashMap<>();
    for(int i = 0; i < str.length(); i++){
      char ch = str.charAt(i);
      if(hm.containsKey(ch)){
        hm.put(ch, hm.get(ch) + 1);
      }
      else hm.put(ch, 1);
    }

    int max = 0;
    char res = 'a';
    for(char key : hm.keySet()){
      if(hm.get(key) > max){
        max = hm.get(key);
        res = key;
      }
    }
    System.out.println(res);
}
}

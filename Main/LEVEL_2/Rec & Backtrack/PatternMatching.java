import java.io.*;
import java.util.*;

public class PatternMatching {

	public static void solution(String str, String pattern, HashMap<Character,String> map, String asf, int indx){
		//write your code here
    if(indx == pattern.length()) {
      if(str.length() == 0) {
        //only if entire string is used
        System.out.println(asf + ".");
      }
      return;
    }
    char ch = pattern.charAt(indx);
    String matching = map.get(ch);
    //find substr
    for(int i = 0; i < str.length(); i++) {
      String substr = str.substring(0, i+1);
      //rest of the string
      String ros = str.substring(i+1);
      map.put(ch, substr);
      //prev current char was mapped with a str.So now we need the exact str to match with current char 
      if(matching.length() > 0) {
        //to move foreward we need the exact str
        if(substr.equals(matching)) {
          solution(ros, pattern, map, asf + ch + " -> " + substr + ", ", indx + 1);
        }
      }else {
        solution(ros, pattern, map, asf + ch + " -> " + substr + ", ", indx + 1);
      }
      //reset
      map.put(ch, matching);
    }
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		HashMap<Character,String> map = new HashMap<>();
    for(int i = 0; i < pattern.length(); i++) {
      char ch = pattern.charAt(i);
      map.put(ch, "");
    }
		solution(str,pattern,map,"", 0);
	}
}
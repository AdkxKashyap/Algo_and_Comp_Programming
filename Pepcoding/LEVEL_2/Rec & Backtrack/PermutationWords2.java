import java.io.*;
import java.util.*;

public class Main {

  public static void generateWords(int cc, String str, Character[] spots, 
                                   HashMap<Character, Integer> lastOccurence) {
    // write your code here
    //level - char, options - box
    if(cc == spots.length) {
        for(char c : spots) System.out.print(c);
        System.out.println();
        return;
    }
    int lo = lastOccurence.get(str.charAt(cc));
    for(int i = lo+1; i < spots.length; i++) {
        if(spots[i] == null) {
            spots[i] = str.charAt(cc);
            lastOccurence.put(str.charAt(cc), i);
            generateWords(cc+1, str, spots, lastOccurence);
            spots[i] = null;
            lastOccurence.put(str.charAt(cc), lo);
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Character[] spots = new Character[str.length()];
    HashMap<Character, Integer> lastOccurence = new HashMap<>();
    for(char ch: str.toCharArray()){
      lastOccurence.put(ch, -1);
    }

    generateWords(0, str, spots, lastOccurence);
  }

}
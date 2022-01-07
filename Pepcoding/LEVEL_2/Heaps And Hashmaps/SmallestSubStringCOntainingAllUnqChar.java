import java.util.*;
public class SmallestSubStringCOntainingAllUnqChar {
  public static int solution(String str){
		// write your code here
    //count unique char
    HashSet<Character> unq = new HashSet<>();
    for(char ch : str.toCharArray()) {
      unq.add(ch);
    }
    int size = unq.size();
    //instead of hmap use array -> faster approach
    int[] map = new int[128];
    int i = 0;
    int j = 0;
    int chCount = 0;
    int ans = Integer.MAX_VALUE;
    
    for(char ch : str.toCharArray()) {
      if(map[ch] == 0) chCount++;
      map[ch]++;
      i++;
      while(j < i && chCount == size)  {
        if(ans > i-j) {
          ans = i-j;
          // minStart = j;
        }
        char cc = str.charAt(j);
        j++;
        map[cc]--;
        if(map[cc] == 0) chCount--;
      }
    }
		return ans == Integer.MAX_VALUE ? -1 : ans;
    //to return smalles string
    // return ans == Integer.MAX_VALUE ? "" : str.substring(minStart, ans+minStart);
	}
}

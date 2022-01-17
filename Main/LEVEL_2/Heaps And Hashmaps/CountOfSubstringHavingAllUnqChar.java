//part of sliding window - see SmallestSubstringOfAStringContaining
public class CountOfSubstringHavingAllUnqChar {
  public static int solution(String str) {
		// write your code here
	
    int[] map = new int[128];
    int i = -1;
    int j = -1;
		boolean flag = false;
    int ans = 0;
    for(char ch : str.toCharArray()) {
      i++;
      if(map[ch] == 1) {
        flag = true;
      }
      map[ch]++;
      while(flag) {
        j++;
        map[str.charAt(j)]--;
        if(map[str.charAt(j) ] == 1) flag = false;
      }
      ans += i-j;
    }
   return ans;
	}
	
}

public class KAnagrams {
  boolean areKAnagrams(String s1, String s2, int k) {
    // code here
    if(s1.length() != s2.length()) return false;
		int[] map = new int[128];
    for(char ch : s1.toCharArray()) {
      map[ch]++;
    }
    for(char ch : s2.toCharArray()) {
      map[ch]--;
    }
    int count = 0;
    for(int c : map) {
      if(c > 0) count+=c;
    }
    //we can change atmost K chars . so if count < k than also return true.
    if(count > k) return false;
    return true;
}
}

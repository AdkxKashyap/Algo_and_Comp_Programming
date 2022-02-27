import java.util.*;


public class CountDistinctSubseq {
  //o{N} space 
  public static long countDistinct1(String S) {
    // int M = (int)1e9+7;
    int n = S.length();
    HashMap<Character, Integer> map = new HashMap<>();
    long[] dp = new long[n+1];
    dp[0] = 1;
    for(int i = 1; i <= n; i++) {
      dp[i] = dp[i-1] * 2;
      char ch = S.charAt(i-1);
      if(map.containsKey(ch)) {
        int j = map.get(ch);
        dp[i] = (dp[i] - dp[j-1]);
      } 
        map.put(ch, i);
      
    }
    // -1 bcoz there will be one empty subseq
    return dp[n]-1;
  }
  //O(1) space leetcode apprtoach. See https://leetcode.com/problems/distinct-subsequences-ii/discuss/199165/Java-Beats-100-O(N)-space-O(1)-space-10-lines-with-simple-explanation
  
  public int distinctSubseqII(String s) {
    int M = (int)1e9+7;
    //hashmap replacement
        int[] carr = new int[26];
        int total = 1;

        for(char ch : s.toCharArray()) {
          int idx = ch-'a';
          int count = 2*total - carr[idx]; //new - duplicates
          /**storing prev arr 
           * eg abc - 
           * carr[b] will be 2 i.e subseq formed by a. If b comes again we will be able to get the duplicates.**/
          carr[idx] = total;
          total = count < 0 ? count+ M : count%M;
        }

        return total;
  }
}

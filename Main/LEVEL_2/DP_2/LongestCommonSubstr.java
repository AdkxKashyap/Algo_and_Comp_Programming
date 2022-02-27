public class LongestCommonSubstr {
  //O(N) space 
  int longestCommonSubstr(String S1, String S2, int n, int m){
    // code here
    int max = Integer.MIN_VALUE;
    int n1 = S1.length();
    int n2 = S2.length();
    int[] dp = new int[n1+1];

    for (int i  = 1; i <= n2; i++ ) {
      int[] tmp = new int[n1+1];
      for(int j = 1; j <= n1; j++) {
        char ch1 = S1.charAt(i-1);
        char ch2 = S2.charAt(j-1);
        if(ch1 != ch2) tmp[j] = 0;
        else {
          tmp[j] = dp[j-1] + 1;
        }
        max = Math.max(max, tmp[j]);
      }
      dp = tmp;
    }
    return max;
}
}

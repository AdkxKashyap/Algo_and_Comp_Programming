//First see top down,similar prob top-down->>https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/642422/for-those-who-have-no-clue-%3A-step-by-step
//bottom-up->https://www.youtube.com/watch?v=0Ql40Llp09E&t=1116s
public class lcs {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()+1][text2.length()+1];
        for(int i=text1.length()-1;i>=0;i--){
            for(int j=text2.length()-1;j>=0;j--){
                dp[i][j]=text1.charAt(i)==text2.charAt(j)?1+dp[i+1][j+1]:Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}

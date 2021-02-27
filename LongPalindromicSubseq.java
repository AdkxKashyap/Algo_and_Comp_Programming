//lc 516
//https://www.youtube.com/watch?v=RiNzHfoA2Lo
// https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99111/Evolve-from-brute-force-to-dp
public class LongPalindromicSubseq {
    public int longestPalindromeSubseq(String s) {
        int[][] dp=new int[s.length()][s.length()];
        //d->diagonal
        for(int d=0;d<s.length();d++){
            for(int i=0,j=d;j<s.length();j++,i++){
                if(d==0)dp[i][j]=1;
                else if(d==1 && s.charAt(i)==s.charAt(j))dp[i][j]=2;
                else{
                    dp[i][j]=s.charAt(i)==s.charAt(j)?2+dp[i-1][j-1]:Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}

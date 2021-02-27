//top down-https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/642422/for-those-who-have-no-clue-%3A-step-by-step
//bottom-up--similar to lcs->https://www.youtube.com/watch?v=0Ql40Llp09E&t=1116s
public class MinASCIIDelSum {
    //bottom up
    public int minimumDeleteSum(String s1, String s2) {
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=s1.length()-1;i>=0;i--){
            dp[i][s2.length()]=dp[i+1][s2.length()]+s1.charAt(i);
        }
        for(int j=s2.length()-1;j>=0;j--){
            dp[s1.length()][j]=dp[s1.length()][j+1]+s2.charAt(j);
        }
        for(int i=s1.length()-1;i>=0;i--){
            for(int j=s2.length()-1;j>=0;j--){
                dp[i][j]=s1.charAt(i)==s2.charAt(j)?dp[i+1][j+1]:Math.min(s1.charAt(i)+dp[i+1][j], s2.charAt(j)+dp[i][j+1]);
            }
        }
        return dp[0][0];
        
    }

    //top-down
    // public int findDeadEndSum(String s,int start){
    //     int sum=0;
    //     for(int i=start;i<s.length();i++){
    //         sum+=s.charAt(i);
    //     }
    //     return sum;
    // }
    // public int helper(String s1,String s2,int i,int j,int memo[][]){
    //     if(i==s1.length() || j==s2.length()){
    //         if(i==s1.length() && j==s2.length()){
    //             return 0;
    //         }
    //         if(i==s1.length()){
    //             return findDeadEndSum(s2, j);
    //         }
    //         else{
    //             return findDeadEndSum(s1, i);
    //         }
    //     }

    //     if(memo[i][j]!=0){
    //         return memo[i][j];
    //     }
    //    int sum=0;
    //     if(s1.charAt(i)==s2.charAt(j)){
    //         sum= helper(s1, s2, i+1, j+1, memo);
    //     }
    //     else{
    //         sum=Math.min(s1.charAt(i)+helper(s1, s2, i+1, j, memo),s2.charAt(j)+ helper(s1, s2, i, j+1, memo));
    //     }
    //     memo[i][j]=sum;
    //     return sum;
    // }
    // public int minimumDeleteSum(String s1, String s2) {
    //     int memo[][]=new int[s1.length()][s2.length()];
    //     return helper(s1, s2, 0, 0, memo);
        
    // }
}

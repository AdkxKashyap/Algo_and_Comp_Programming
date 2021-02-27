//https://leetcode.com/problems/edit-distance/discuss/25895/Step-by-step-explanation-of-how-to-optimize-the-solution-from-simple-recursion-to-DP
public class EditDistance {
    public int helper(String word1, String word2,int i,int j,int memo[][]){
        if(i==word1.length() || j==word2.length()){
            if(i==word1.length() && j==word2.length())return 0;
            return (i==word1.length()?word2.length()-j:word1.length()-i);
        }
        if(memo[i][j]!=0)return memo[i][j];
        memo[i][j]=word1.charAt(i)==word2.charAt(j)?helper(word1, word2, i+1, j+1, memo):Math.min(
                                                                1+helper(word1, word2, i, j+1, memo),
                                                    Math.min(1+helper(word1, word2, i+1, j, memo), 1+helper(word1, word2, i+1, j+1, memo)));
        
        return memo[i][j];                                                       
    }
    public int minDistance(String word1, String word2) {
        if(word1.length()==0 && word2.length()==0){
            return 0;
        }
        int memo[][]=new int[word1.length()][word2.length()];
        return helper(word1, word2,0,0,memo);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[]=new boolean[s.length()+1];//in s.substring(0,s.len) means 0 to len-1 so one extra space is need.
        Arrays.fill(dp, false);
        dp[0]=true;//0 to 0-1 is empty
        Set<String> dict=new HashSet<>();
        dict.addAll(wordDict);
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                dp[i]=dp[j] && dict.contains(s.substring(j, i))?true:dp[i];//dp[j] means s[0 to j-1].This statement means
                                                                            /**Weather s[0 to j-1] and s[j to i-1] exists in dict */   
                if(dp[i])break;                                                    
            }
        } 
        return dp[s.length()];
    }
    public static void main(String[] args) {
        WordBreak test=new WordBreak();
        String s="leetcode";
        List<String>list=new ArrayList<String>();
        list.add("leet");
        list.add("code");
        System.out.println(test.wordBreak(s, list));
    }
}

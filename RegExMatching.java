//lc10
//https://www.youtube.com/watch?v=DJvw8jCmxUU&t=1481s
//Also see wildcard matching lc44
public class RegExMatching {
    public boolean isMatch(String s, String p) {
        if(p==null || s==null)return false;
        boolean[][] dp=new boolean[p.length()+1][s.length()+1];
        dp[0][0]=true;
        for(int i=1;i<=p.length();i++){
            if(p.charAt(i-1)=='*'){dp[i][0]=dp[i-2][0];}
        }
        for(int i=1;i<=p.length();i++){
            for(int j=1;j<=s.length();j++){
                if(p.charAt(i-1)==s.charAt(j-1) || p.charAt(i-1)=='.'){dp[i][j]=dp[i-1][j-1];}
                else if(p.charAt(i-1)=='*'){
                    if(p.charAt(i-2)!='.'&& (dp[i-2][j] || (s.charAt(j-1)==p.charAt(i-2) && dp[i][j-1]))){
                        dp[i][j]=true;
                    }
                    else if(p.charAt(i-2)=='.'){
                        dp[i][j]=dp[i-2][j] || dp[i][j-1];
                    }  
                }   
                else if(p.charAt(i-1)!=s.charAt(j-1)){dp[i][j]=false;}       
            }
        }
        return dp[p.length()][s.length()];
    }
    public static void main(String[] args) {
        RegExMatching test=new RegExMatching();
        System.out.println(test.isMatch("ab", ".*"));
    }
}

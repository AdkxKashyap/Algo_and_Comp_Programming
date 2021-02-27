//91. Decode Ways
public class DecodeWays {
    //TOP DOWN
    // https://leetcode.com/problems/decode-ways/discuss/30358/Java-clean-DP-solution-with-explanation  -comment section
    public int numDecodings(String s) {
        if(s.length()==0)return 0;
        if(s.charAt(0)=='0')return 0;
        int[] dp=new int[s.length()];
        dp[0]=1;
        for(int i=1;i<s.length();i++){
            if(Integer.valueOf(s.substring(i,i+1))>0 && Integer.valueOf(s.substring(i,i+1))<10 ){
                dp[i]+=dp[i-1];
            }
            if(Integer.valueOf(s.substring(i-1,i+1))>=10 && Integer.valueOf(s.substring(i-1,i+1))<=26 ){
                dp[i]+=i>=2?dp[i-2]:1;
            }
        }
        return dp[s.length()-1];
    }
    // public int helper(String s,int start,int[] memo){
    //     if(start>=s.length())return 1;
    //     if(memo[start]!=0)return memo[start];
    //     if(s.charAt(start)=='0')return 0;
    //     int count=0,stopCount=0;

    //     for(int i=start;i<s.length();i++){
         
    //         if(stopCount==2)break;
    //         if(Integer.parseInt(s.substring(start, i+1))<=26 
    //             && Integer.parseInt(s.substring(start, i+1))>0){
    //             count+=helper(s, i+1, memo);
    //         }
    //         stopCount++;//we only need two digits since max is 26.Eg 226 is invalid so i will go till index 1 i.e 2 and 26.
    //     }
    //     memo[start]=count;
    //     return count;
    // }
    // public int numDecodings(String s) {
    //         if(s.length()==0)return 0;
    //     int[] memo=new int[s.length()];
    //     return helper(s, 0, memo);
    // }

    public static void main(String[] args) {
        DecodeWays test=new DecodeWays();
        String s="226";
        System.out.println(test.numDecodings(s));
    }
}

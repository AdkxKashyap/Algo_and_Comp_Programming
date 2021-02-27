//lc583
//same as edit distance
//bottom up from index 0 instead of last index and space o(N)
//also see lcs
public class DelOpsTwoStrings {
    public int minDistance(String s1, String s2) {
      int dp[]=new int[s2.length()+1];
      for(int i=0;i<=s1.length();i++){
          int tmp[]=new int[s2.length()+1];
          for(int j=0;j<=s2.length();j++){
            if(i==0 || j==0){
                tmp[j]=i+j;
            }
            else{
                tmp[j]=s1.charAt(i-1)==s2.charAt(j-1)?dp[j-1]:1+Math.min(tmp[j-1], dp[j]);
            }
          }
          dp=tmp;
      }
      return dp[s2.length()];
    }
    // public static void main(String[] args) {
    //     lc583 test=new lc583();
    //     System.out.println(test.minDistance("sea", "eat"));
    // }
}

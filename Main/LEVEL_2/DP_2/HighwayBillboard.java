import java.util.HashMap;

public class HighwayBillboard {
  public static int solution(int m , int[] x, int[] rev, int t) {
    // write your code here
    int[] dp = new int[m+1];
    HashMap<Integer, Integer> hmap = new HashMap<>();
    for(int i = 0; i < x.length; i++) {
      hmap.put(x[i], rev[i]);
    }
    for(int i = 1; i < m; i++) {
      if(!hmap.containsKey(i)) {
        dp[i] = dp[i-1];
      } else {
        if(i-t-1 >= 0) {
          dp[i] = Math.max(dp[i-1], dp[i-t-1] + hmap.get(i));
        } else {
          dp[i] = Math.max(dp[i-1], hmap.get(i));
        }
        
      }
    }
    return dp[m];
}
}

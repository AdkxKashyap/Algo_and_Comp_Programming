import java.util.*;

public class MaxLengthofPairChain {
  public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b)-> a[0]-b[0]);

        int lis = findLIS(pairs);
        return lis;

  }

  public int findLIS(int[][] arr) {
    int[] dp = new int[arr.length];
    int max = 0;
    for(int i = 0; i < arr.length; i++) {
      int tmpmax = 0;
      for(int j = 0; j < i; j++) {
        if(arr[j][1] < arr[i][0]) {
          tmpmax = Math.max(tmpmax, dp[j]);
        }
      }
      dp[i] = tmpmax+1;
      max = Math.max(dp[i], max);
    }
    return max;
  }
}

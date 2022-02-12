import java.util.Arrays;
import java.util.Scanner;

public class RussianDollEnvelope {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][2];
    for(int i = 0; i < n; i++) {
      arr[i][0] = sc.nextInt();
      arr[i][1] = sc.nextInt();
    }
    System.out.println(maxEnvelopes(arr));
  }
  //LIS o(n^2) 
  public static int maxEnvelopes(int[][] envelopes) {
        int res = 0;
        //sort according to wd
        Arrays.sort(envelopes, (a, b)-> {
          if(a[0] != b[0])
            return a[0]-b[0];
          else {
            //if width same , elem with greater ht will come first
            return b[1]-a[1];
          }
        });
        /**LIS of height. Width and ht will be strictly increasing */
        int[] dp = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++) {
          int tmp = 0;
          for(int j = 0; j < i; j++) {
            if(envelopes[j][0] != envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
              tmp = Math.max(dp[j], tmp);
            }
          }
          dp[i] = tmp+1;
          res = Math.max(dp[i], res);
        }
        return res;
  }
  //LIS o(nlogn) using binary search
  public static int maxEnvelopes2(int[][] envelopes) {
    //sort according to wd
    Arrays.sort(envelopes, (a, b)-> {
      if(a[0] != b[0])
        return a[0]-b[0];
      else {
        //if width same , elem with greater ht will come first
        return b[1]-a[1];
      }
    });
    /**LIS of height. 
     * if arr = {10, 4,5}
     * dp[2] = 5 means max lis size = 2 and last elem of lis = 5
     * **/
    int[] dp = new int[envelopes.length];
    int len = 0;
    for(int i = 0; i < envelopes.length; i++) {
      int idx = Arrays.binarySearch(dp, 0, len, envelopes[i][1]);
     
      if(idx < 0) {
        idx = -(idx+1);
      }

      dp[idx] = envelopes[i][1];
      if(idx == len) len++;
    }
    return len;
}
}

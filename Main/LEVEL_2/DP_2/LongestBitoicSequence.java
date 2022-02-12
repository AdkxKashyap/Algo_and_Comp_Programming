import java.util.*;
//lc 1671 - Similar q.
public class LongestBitoicSequence {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    System.out.println(getSeq(arr));
   }
   public static int getSeq(int[] arr) {
    int ans = 0;
    int[] lis = getLIS(arr);
    int[] lds = getLDS(arr);
    for(int i = 0; i < arr.length; i++) {
      ans = Math.max(ans, lis[i]+lds[i]);
    }
    return ans;
   }
  public static int[] getLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j] <= nums[i]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max+1;
        }
        return dp;
  }

  public static int[] getLDS(int[] nums) {
    int[] dp = new int[nums.length];
   
    for(int i = nums.length-1; i >= 0; i--) {
        int max = 0;
        for(int j = nums.length-1; j > i; j--) {
            if(nums[j] <= nums[i]) {
                max = Math.max(dp[j], max);
            }
        }
        dp[i] = max+1;
    }
    return dp;
}
}

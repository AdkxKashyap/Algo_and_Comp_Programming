import java.io.*;
import java.util.*;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(lengthOfLIS(arr));
    }

    public int lengthOfLIS(int[] nums) {
        int omax = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < i; j++) {
                if(arr[j] < nums[i]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max+1;
            omax = Math.max(omax, dp[i]);
        }
        return omax;
    }

}
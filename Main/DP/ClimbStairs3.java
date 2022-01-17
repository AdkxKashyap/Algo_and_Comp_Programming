package Main.DP;


  
import java.io.*;
import java.util.*;

public class ClimbStairs3 {
    
  //Minsteps required to reach top
    public static int minSteps(int stair, int n, int[] jumps, int[] dp) {
        if(n == stair) return 0;
        if(dp[stair] != 0) return dp[stair];
        /** when jump[i] = 0 and we cannot move further return 1e9 + 1 intead of max_val + 1 which gives '-' value*/
        int minJumps = (int)1e9;
        int jumpWays = jumps[stair];
        for(int i = 1; i <= jumpWays && stair + i <= n; i++) {
            minJumps = Math.min(minJumps, minSteps(stair + i, n, jumps, dp));
        }
        return dp[stair] = minJumps + 1;
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        int res = minSteps(0,  n, arr,  dp);
        System.out.println(res);
    }

}

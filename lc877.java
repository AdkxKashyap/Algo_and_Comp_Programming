public class lc877 {
    public int helper(int arr[],int start,int end,int dp[][]){
        if(start==end){
            return arr[start];
        }
        if(dp[start][end]!=0){
            return dp[start][end];
        }
         dp[start][end]=Math.max(arr[start]-helper(arr, start+1, end,dp), arr[end]-helper(arr, start, end-1,dp));
        return dp[start][end];
    }
    public boolean stoneGame(int[] p) {
        int dp[][]=new int[500][500];
     return helper(p, 0, p.length-1,dp)>0;
    }
}

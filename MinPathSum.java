public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int dp[]=new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            int tmp[]=new int[grid[0].length];
            for(int j=0;j<grid[0].length;j++){
                if(i==0 || j==0){
                    if(i==0 && j==0)tmp[j]=grid[0][0];
                    else{
                        tmp[j]=i==0?grid[i][j]+tmp[j-1]:grid[i][j]+dp[j];
                    }
                }
                else{
                    tmp[j]=grid[i][j]+Math.min(tmp[j-1], dp[j]);
                }
            }
            dp=tmp;
        }
        return dp[grid[0].length-1];
    }
}

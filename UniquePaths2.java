//Unique paths 2
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp=new int[obstacleGrid[0].length];
        dp[0]=1;
        for(int[] row:obstacleGrid){
            dp[0]=row[0]==1?0:dp[0];
            for(int j=1;j<obstacleGrid[0].length;j++){
                dp[j]=row[j]==1?0:dp[j]+dp[j-1];
            }
        }
        return dp[obstacleGrid[0].length-1];
    }
}

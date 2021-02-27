import java.util.Arrays;
//lc300
public class LongestIncreasingSubseq {

    public int lengthOfLIS(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp, 1);
        int gMax=1;
        for(int i=1;i<nums.length;i++){
            int j=i-1;
            while(j>=0){
                dp[i]=nums[i]>nums[j]?Math.max(dp[i], dp[j]+1):dp[i];
                j--;
            }
            gMax=Math.max(gMax, dp[i]);//max size of subsequence,/**Using gmax bcoz longest will not 
                                                                //always be at dp[size-1],It can be in the middle also.So to keep track of largest subseq gmax is used. */
        }
        return gMax;
    }

    //TOP-DOWN Accepted
    // public int helper(int nums[],int current,int memo[]){
    //     if(memo[current]!=0)return memo[current];
    //     int size=1;
    //     int res=0;
    //     for(int i=current+1;i<nums.length;i++){
    //         res=nums[current]<nums[i]?helper(nums, i, memo):0;
    //         size=Math.max(size, res+1);
    //     }
    //     memo[current]=size;
    //     return size;
    // }
    // public int lengthOfLIS(int[] nums) {
    //     int memo[]=new int[nums.length];
    //     int size=1;
    //     for(int i=0;i<nums.length;i++){
    //         size=Math.max(size, helper(nums, i, memo));
    //     }
    //     return size;
    // }


    //test cases did not pass
    // public int lengthOfLIS(int[] nums) {
    //     int dp[][]=new int[nums.length][nums.length];
    //     dp[0][0]=1;
    //     for(int i=0;i<nums.length;i++){
    //         int max=1;
    //         for(int j=i;j<nums.length;j++){
    //             if(i==0){
    //                 if(nums[j]>nums[i]){
    //                     dp[i][j]=dp[0][0]+1;
    //                 }       
    //             }
    //             else if(i==j){
    //                 max=dp[i][j]=dp[i-1][j];
    //                 continue;
    //             }
    //             else{
    //                 if(nums[j]>nums[i]){
    //                     dp[i][j]=Math.max(max+1, dp[i-1][j]);
    //                 }
    //                 else{
    //                     dp[i][j]=dp[i-1][j];
    //                 }
                    
    //             }
                
    //         }
    //     }
    //     return dp[nums.length-1][nums.length-1];
    // }
    public static void main(String[] args) {
        LongestIncreasingSubseq test=new LongestIncreasingSubseq();
        int arr[]={1,3,6,7,9,4,10,5,6};
        // test.lengthOfLIS(arr);
        System.out.println(test.lengthOfLIS(arr));
    }
}

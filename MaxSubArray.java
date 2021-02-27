// Maximum Subarray
//Explanation-https://leetcode.com/problems/maximum-subarray/discuss/20193/DP-solution-and-some-thoughts
// 1st comment

class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int i;
        int max=nums[0];
        for(i=1;i<nums.length;i++){
            if(nums[i-1]>0){
                nums[i]=nums[i-1]+nums[i];
            }
            max=Math.max(max,nums[i]);
        }
        return max;
}
    public int max(int a,int b){
        if(a>b){
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        int arr[]= {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxSubArray().maxSubArray(arr));
    }
}

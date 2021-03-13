class MissingNumber{
    public int missingNumber(int[] nums) {
        int sumIndex=0,sumArr=0;
        for(int i=0;i<nums.length;i++){
            sumIndex+=i+1;
            sumArr+=nums[i];
        }
        return sumIndex-sumArr;
    }
}
//House robber 2
//check part 1 similar question
public class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length<=2){
           if(nums.length==0)return 0;
           else if(nums.length==2)return Math.max(nums[0], nums[1]);
           return nums[0];
       }
        int ans=0;
        int tmp[]=new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        //Start from 0 to N-1
        for(int i=2;i<tmp.length-1;i++){
            if(i==2){
                tmp[i]=tmp[i]+tmp[i-2];continue;}
                tmp[i]=Math.max(tmp[i]+tmp[i-2], tmp[i]+tmp[i-3]);
        }
        ans=Math.max(tmp[tmp.length-2], tmp[tmp.length-3]) ;
         //Start from 1 to N
         for(int i=3;i<nums.length;i++){
            if(i==3){nums[i]=nums[i]+nums[i-2];}
            else{nums[i]=Math.max(nums[i]+nums[i-2], nums[i]+nums[i-3]);}
        }
        return Math.max(Math.max(ans, nums[nums.length-1]), nums[nums.length-2]) ;
   }
   public static void main(String[] args) {
       HouseRobber2 test=new HouseRobber2();
       int[] arr={200,3,140,20,10};
       System.out.println(test.rob(arr));
   }
}

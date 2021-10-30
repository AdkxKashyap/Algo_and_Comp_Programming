import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    int len=0;
    List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
         for(int i=0;i<nums.length+1;i++){
            this.len=i;
            helper(nums,new ArrayList<Integer>(),0,new boolean[nums.length]);
        }
        return res;  
    }
    public void helper(int nums[],ArrayList<Integer>tmp,int start,boolean used[]){
        if(tmp.size()==len){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1] && !used[i-1])continue;
            tmp.add(nums[i]);
            used[i]=true;
            helper(nums, tmp, i+1,used);
            tmp.remove(tmp.size()-1);
            used[i]=false;
        }
    }
}

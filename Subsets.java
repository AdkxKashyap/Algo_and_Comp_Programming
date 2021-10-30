import java.util.ArrayList;
import java.util.List;

public class Subsets {
    int len=0;
    List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        for(int i=0;i<nums.length+1;i++){
            this.len=i;
            helper(nums,new ArrayList<Integer>(),0);
        }
        return res;  
    }
    public void helper(int nums[],ArrayList<Integer>tmp,int start){
        if(tmp.size()==len){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<nums.length;i++){
            tmp.add(nums[i]);
            helper(nums, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==1)return List.of(new ArrayList<Integer>(nums[0]));
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            List<List<Integer>>tmpList=new ArrayList<>();
            int delItem=nums[0];
            nums=Arrays.copyOfRange(nums,1,nums.length);
            tmpList=permute(nums);
            for(List<Integer>list:tmpList){
                list.add(delItem);
            }
            ans.addAll(tmpList);
            nums[nums.length]=
        }
        return ans;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 * For another approach see permutation1.js
 * Alse see all similar questions
 */
public class Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>resList=new ArrayList<>();
        helper(resList, nums, new boolean[nums.length], new ArrayList<>());
        return resList;
    }
    public void helper(List<List<Integer>>resList,int[]nums,boolean[] used,List<Integer>tmpList){
        if(tmpList.size()==nums.length)resList.add(new ArrayList<>(tmpList));
        for(int i=0;i<nums.length;i++){
            if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1])continue;
            used[i]=true;
            tmpList.add(nums[i]);
            helper(resList, nums, used, tmpList);
            used[i]=false;
            tmpList.remove(tmpList.size()-1);
        }
    }
}

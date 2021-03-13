import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**Solition combsum 1,2,3-https://leetcode.com/problems/combination-sum-ii/discuss/16878/Combination-Sum-I-II-and-III-Java-solution-(see-the-similarities-yourself)
 * Also see permutation.Same concept
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        Arrays.sort(candidates);
        helper(target, res, candidates, new ArrayList<>(), 0);
        return res;
    }
    public void helper(int target,List<List<Integer>>res,int[] candidates ,List<Integer> tmp,int start){
        if(target==0)res.add(new ArrayList<>(tmp));
        else if(target<0)return;
        else{
            for(int i=start;i<candidates.length;i++){
                if(i>start && candidates[i]==candidates[i-1])continue;
                tmp.add(candidates[i]);
                helper(target-candidates[i], res, candidates, tmp, i+1);
                tmp.remove(tmp.size()-1);
            }
        }
       
    }
}

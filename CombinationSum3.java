import java.util.ArrayList;
import java.util.List;

class CombinationSum{
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>res=new ArrayList<>();
        helper(n,res,new ArrayList<>(),1,k);
        return res;
    }
    void helper(int target,List<List<Integer>> res,List<Integer> tmp,int start,int k){
        if(target==0 && tmp.size()<k)return;
        if(target!=0 && tmp.size()==k)return;
        if(target==0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<=9;i++){
            tmp.add(i);
            helper(target-i, res, tmp, i+1,k);
            tmp.remove(tmp.size()-1);
        }
    }
}
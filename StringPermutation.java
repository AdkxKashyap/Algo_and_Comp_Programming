import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//See Permutation2.java
public class StringPermutation {
    public List<String>getPermutations(String str){
        char[] strArr=str.toCharArray();
        Arrays.sort(strArr);
        List<String>res=new ArrayList<>();
        helper(strArr, res,new boolean[strArr.length],new ArrayList<>());
        return res;
        
    }
    void helper(char[] strArr,List<String>res,boolean[] used,List<Character>tmp){
        if(tmp.size()==strArr.length){
            StringBuilder sb=new StringBuilder();
            for(Character ch:tmp)sb.append(ch);
            res.add(sb.toString());
        }
        for(int i=0;i<strArr.length;i++){
            if(used[i] || i>0 && strArr[i]==strArr[i-1] && !used[i-1])continue;
            tmp.add(strArr[i]);
            used[i]=true;
            helper(strArr, res, used, tmp);
            used[i]=false;
            tmp.remove((tmp.size()-1));
        }
    }
    public static void main(String[] args) {
        String test="bac";
        List<String>str=new StringPermutation().getPermutations(test);
        for(String s:str)System.out.println(s);
    }
}

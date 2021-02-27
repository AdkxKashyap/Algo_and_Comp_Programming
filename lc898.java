/**could not understand time complexity
 * https://leetcode.com/problems/bitwise-ors-of-subarrays/discuss/165881/C%2B%2BJavaPython-O(30N)
 * for solution->https://leetcode.com/problems/bitwise-ors-of-subarrays/discuss/399300/Intuitive-Java-Solution-With-Explanation
*/
import java.util.HashSet;
import java.util.Set;

class lc898 {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> current,prev=new HashSet<>(),ans=new HashSet<>();
        for(int x:arr){
            current=new HashSet<>();//all solution of current x will be stored here.
            prev.add(0);//to add current x. x|0=>x
            for(int y:prev){
                current.add(x|y);
                ans.add(x|y);
            }
            prev=current;
        }
        return ans.size();
    }
}
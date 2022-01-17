package Main.LEVEL_2.Arrays_Strings;
import java.util.*;
public class PascalTriangle2 {
  public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new LinkedList<>();
        /**rowIdx             rowIdx
         *      C  * i-j/j+1=       C
         *        j                   j+1
         * 
         * see notes
         */
        //take long for leetcode 
        long val = 1;
        
        for(int j = 1; j <= rowIndex; j++) {
            res.add((int)val);
            val = val * (rowIndex-j)/(j+1);
        }

        return res;
  }
}

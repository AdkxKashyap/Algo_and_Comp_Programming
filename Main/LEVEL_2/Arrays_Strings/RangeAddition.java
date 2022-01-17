package Main.LEVEL_2.Arrays_Strings;
import java.util.*;

public class RangeAddition {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] getModifiedArray(int length, int[][] queries) {
        // write your code here
        int[] res = new int[length];
        for(int i = 0; i < queries.length; i++) {
          res[queries[i][0]] += queries[i][2];
          if(queries[i][1]+1< length) {
            res[queries[i][1]+1] += -queries[i][2];
          }
        }
         int sum = 0;
         for(int k = 0; k < length; k++) {
            sum += res[k];
            res[k] = sum;
          }
        return res;
      }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int length = scn.nextInt();

        int nq = scn.nextInt();
        
        int[][] queries = new int[nq][3];

        for(int q = 0; q < nq; q++) {
            queries[q][0] = scn.nextInt();
            queries[q][1] = scn.nextInt();
            queries[q][2] = scn.nextInt();
        }


        int[] res = getModifiedArray(length, queries);

        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
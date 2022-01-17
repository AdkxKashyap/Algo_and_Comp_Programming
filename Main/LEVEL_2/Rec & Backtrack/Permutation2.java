import java.io.*;
import java.util.*;

public class Permutation2 {
  //level->boxes, options-> choice of items
  public static void permutations(int cb, int tb, int[] items, int ci, int ti, String asf){
    // write your code here
    //since init cb = 1 in main, so cb > tb if cb would have started frm 0 than check cb == tb
    if(cb > tb) {
      //curr item == tot item.i.e only when all items are placed in box print
      if(ti == ci) {
        System.out.println(asf);
      }
      return;
    }
    //yes call
    for(int i = 0; i < ts; i++) {
      if(items[i] == 0) {
        items[i] = 1;
        permutations(cb + 1, tb, items, ti + 1, ci, asf + (i+1));
        items[i] = 0;
      }
    }
    //no call
    permutations(cb + 1, tb, items, ssf, ts, asf + 0);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(1, nboxes, new int[ritems], 0, ritems, "");
  }

}
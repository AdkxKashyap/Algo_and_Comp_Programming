import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(int cb, int tb, int ci, int ti, String asf){
    // write your code here
    if(cb > tb) {
        if(ti == ci) {
            System.out.println(asf);
        }
        // System.out.println();
        return;
    }
    //yes call - place curr i in box
    combinations(cb + 1, tb, ci + 1, ti, asf + "i");
    //no call
    combinations(cb + 1, tb, ci, ti, asf + "-");
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(1, nboxes, 0, ritems, "");
  }

}
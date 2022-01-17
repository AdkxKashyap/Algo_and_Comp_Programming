package Main.LEVEL_2.Arrays_Strings;
import java.util.*;

public class CarFleet {
  //lc - 853
  public int carFleet(int target, int[] position, int[] speed) {
    int n = position.length;
    double[][] cardata = new double[n][2];
    /** 0 - pos 
     * 1 - time to reach target **/
    for(int i = 0; i < n; i++) {
      cardata[i][0] = position[i];
      cardata[i][1] = ((target-position[i])*1d)/speed[i];
    }
    Arrays.sort(cardata,(a,b)->(Double.compare(a[0], b[0])));
    int res = 1;
    double tt = cardata[n-1][1];
    for(int i = n-2; i>=0; i--) {
      if(cardata[i][1] > tt) {
        res++;
        tt = cardata[i][1];
      }
    }
    return res;
  }
}

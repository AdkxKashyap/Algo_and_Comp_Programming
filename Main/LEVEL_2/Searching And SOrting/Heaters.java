import java.util.Arrays;

public class Heaters {
  class Pair{
    int js = -1;
    int jl = -1;
  }
  /**We need to find for each house just smaller and just larger distance from heater and take Min of that.This is similar to K nearest Problem  
   * Max of min of all dist is the ans.
  */
  public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        Arrays.sort(heaters);
        for(int i = 0; i < houses.length; i++) {
          Pair p = binarySearch(houses[i], heaters);
          int js = p.js == -1 ? Integer.MAX_VALUE : houses[i]-p.js;
          int jl = p.jl == -1 ? Integer.MAX_VALUE : p.jl-houses[i];
          int min = Math.min(js, jl);
          if(min > ans) {
            ans = min;
          }
        }
        return ans;
  }
  public Pair binarySearch(int val, int[] heaters) {
    int l = 0;
    int r = heaters.length-1;
    Pair p = new Pair();
    while(l <= r) {
      int mid = l + (r-l)/2;
      if(val == heaters[mid]) {
        //house itself is the heater
        p.js = heaters[mid];
        p.jl = heaters[mid];
        break;
      }
      else if(heaters[mid] < val) {
        p.js = heaters[mid];
        l = mid+1;
      } else {
        p.jl = heaters[mid];
        r = mid-1;
      }
    }
    return p;
  }
}

import java.util.*;
public class MaxCostLaptopCount {
  public static int maxCost(List<Integer> cost, List<String> labels, int dailyCount) {
    // Write your code here
      
      int j = 0;
      int i = 0;
      int ans = 0;
      while(i < cost.size()) {
        int pans = 0;
        int dcount = 0;
        while(j < cost.size() && dcount < dailyCount) {
          pans += cost.get(j);
          if(labels.get(j).equals("legal")) dcount++;
          j++;
        }
        if(dcount == dailyCount) {
          ans = Math.max(pans, ans);
        }
        i = j;
      }
      return ans;
    }
}

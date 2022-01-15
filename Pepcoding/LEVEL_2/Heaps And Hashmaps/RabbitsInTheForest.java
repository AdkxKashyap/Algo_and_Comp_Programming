import java.util.HashMap;

public class RabbitsInTheForest {
  public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ans : answers) {
          map.put(ans, map.getOrDefault(ans, 0)+1);
        }
        int ans = 0;
        for(int key : map.keySet()) {
          int gp = key+1;
          int reportees = map.get(key);
          ans = (int)Math.ceil(reportees*1.0/gp*10) * gp;
        }
        return ans;
  }
}

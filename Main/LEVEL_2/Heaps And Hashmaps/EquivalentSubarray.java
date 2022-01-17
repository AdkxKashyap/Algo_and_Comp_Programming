import java.util.*;

public class EquivalentSubarray {
  public static int solution(int[] arr) {
    int j = 0;
    int n = arr.length;
    int sz = 0;
    int ans = 0;
    HashMap<Integer, Integer> fmap = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    for(int v : arr) set.add(v);
    sz = set.size();
    for(int i = 0; i < n; i++) {
      //acquire
      fmap.put(arr[i], fmap.getOrDefault(arr[i], 0)+1);
      while(fmap.size() == sz) {
        ans += n-i;
        //release
        int v = arr[j];
        j++;
        fmap.put(v, fmap.get(v)-1);
        if(fmap.get(v) == 0) fmap.remove(v);
      }
    }
    return ans;
  }
}

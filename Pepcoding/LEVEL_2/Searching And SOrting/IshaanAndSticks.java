import java.util.*;

public class IshaanAndSticks {
  public static ArrayList<Integer> square (int arr[], int n) {
    //Complete the function
    int max = Integer.MIN_VALUE;
    int cnt = 0;
    ArrayList<Integer> res = new ArrayList<>();
    HashMap<Integer, Integer> hmap = new HashMap<>();
    for(int i = 0; i < n; i++) {
        if(!hmap.containsKey(arr[i])) {
            hmap.put(arr[i], 1);
        } else {
            hmap.put(arr[i], hmap.get(arr[i]) + 1);
        }
    }
    for(int val : hmap.keySet()) {
        int sticks = hmap.get(val);
        if(sticks >= 4) {
            int area = val*val;
            if(max < area) {
                max = area;
                cnt = sticks/4;
            }
        };
    }
    if(max == Integer.MIN_VALUE) {
        res.add(-1);
        return res;
    }
    res.add(max);
    res.add(cnt);
    return res;
}
}

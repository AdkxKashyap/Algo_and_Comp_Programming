package Main.LEVEL_2.Arrays_Strings;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeInterval {
  public int[][] merge(int[][] intervals) {
    ArrayList<int[]> res = new ArrayList<>();

    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int start = intervals[0][0];
    int end = intervals[0][1];
    for (int j = 1; j < intervals.length; j++) {
      int st = intervals[j][0];
      int en = intervals[j][1];
      if (st <= end) {
        end = Math.max(end, en);
        // start = Math.min(start, st);
      } else {
        res.add(new int[] { start, end });
        start = st;
        end = en;
      }
    }
    res.add(new int[] { start, end });
    return res.toArray(new int[0][]);
  }
}
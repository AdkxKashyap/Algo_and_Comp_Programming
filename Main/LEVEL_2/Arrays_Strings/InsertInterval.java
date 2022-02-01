package Main.LEVEL_2.Arrays_Strings;
import java.util.ArrayList;

public class InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    ArrayList<int[]> res = new ArrayList<>();
    int i = 0;
    //adding all interval to res starting and ending before new interval
    while(i < intervals.length && intervals[i][1] < newInterval[0]) {
      res.add(new int[]{intervals[i][0], intervals[i][1]});
      i++;
    }
    int end = newInterval[1];
    int start = newInterval[0];
    while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
      end = Math.max(end, intervals[i][1]);
      start = Math.min(start, intervals[i][0]);
        i++;
    }
    res.add(new int[]{start, end});
    while(i < intervals.length) {
      res.add(new int[]{intervals[i][0], intervals[i][1]});
        i++;
    }
    return res.toArray(new int[0][]);
  }

}

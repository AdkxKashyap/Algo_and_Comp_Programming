package Main.LEVEL_2.Arrays_Strings;
public class MeetingRooms2 {
  public static boolean meetingRooms(int intervals[][]) {
    // write code here
    int start = intervals[0][0];
    int end = intervals[0][1];
    for (int j = 1; j < intervals.length; j++) {
      int st = intervals[j][0];
      int en = intervals[j][1];
      if (st <= end) {
        return false;
      } else {
        start = st;
        end = en;
      }
    }
    return true;
  }
}

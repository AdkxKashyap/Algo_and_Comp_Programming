import java.util.*;

public class MeetingRooms2 {
  public static int meetingRooms(int intervals[][]) {
    // write your code here
    if(intervals.length == 0) return 0;
    Arrays.sort(intervals, (a, b) ->  a[1]-b[1]);
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    //add first meeting
    pq.add(intervals[0][1]);

    for(int i = 0; i < intervals.length; i++) {
      if(pq.peek() > intervals[i][0]) {
        //we need a new room
        pq.add(intervals[i][1]);
      } else {
        //add meeting in an existing room
        pq.poll();
        pq.add(intervals[i][1]);
      }
    }
    return pq.size();
  }
}

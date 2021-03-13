import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
//not tested
public class MeetingRooms2 {
    public int minMeetingRooms(List<Interval> intervals) {
        int count=0;
        Collections.sort(intervals,new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}     
        });

       Iterator<Interval> itr=intervals.listIterator();
       Interval prev=itr.next();
       Interval curr=null;
       while(itr.hasNext()){
           curr=itr.next();
           if(prev.end>curr.start)count++;
       }
        return count;
    }
}

class Interval{
    int start,end;
    Interval(int start,int end){
        this.start=start;
        this.end=end;
    }
}
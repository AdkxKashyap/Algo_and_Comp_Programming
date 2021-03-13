import java.util.Arrays;
import java.util.Comparator;
//see meeting rooms 2
public class MeetingRooms1 {
    boolean find(int[][] intervals){
        Arrays.sort(intervals,new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			} 
        });
        int i=0;
        while(i<intervals.length-1 && intervals[i][1]<=intervals[i+1][0])i++;
        return i>intervals.length-2?true:false;
    }

        public static void main(String[] args) {
            MeetingRooms1 test=new MeetingRooms1();
            // int[][] arr={{7,10},{2,4}};
            int[][] arr={{0,30},{5,10},{15,20}};
            System.out.println(test.find(arr)); 
        }
    }


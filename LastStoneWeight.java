import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//lc1046
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(stones.length,Collections.reverseOrder());
        for(int i:stones)pq.add(i);
        while(pq.size()>1){
            int max1=pq.poll();
            int max2=pq.poll();
            if(max1-max2!=0)pq.add(max1-max2);
        }
        return (pq.size()==1?pq.poll():0);
    }
}

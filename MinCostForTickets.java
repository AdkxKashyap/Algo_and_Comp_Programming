//https://www.youtube.com/watch?v=HyN5hdD1JU4-->bottom-up
//see copy for tree creation
public class MinCostForTickets {
    public int helper(int[] days, int[] costs,int currDayIndex,int[] memo){
        if(costs.length==0 || days.length==0)return 0;
        if(currDayIndex>=days.length)return 0;
        if(memo[currDayIndex]!=0)return memo[currDayIndex];
        int monthTracker=currDayIndex;
        int dayTracker=currDayIndex;
        while((days[dayTracker]<days[currDayIndex]+7) && dayTracker<days.length){
            dayTracker++;
            if(dayTracker>=days.length)break;
        }
        //start day<start day+30 if we have the 30 day pass we need not pay for 30 days.
        while((days[monthTracker]<days[currDayIndex]+30) && monthTracker<days.length){
            monthTracker++;
            if(monthTracker>=days.length)break;
        }
        memo[currDayIndex]=Math.min(costs[0]+helper(days, costs, currDayIndex+1, memo),//for 1day pass
                            Math.min(costs[1]+helper(days, costs, dayTracker, memo), //for week pass
                            costs[2]+helper(days, costs, monthTracker, memo)));     //for monthly pass               
        return memo[currDayIndex];
    }
    public int mincostTickets(int[] days, int[] costs) {
        int[] memo=new int[days.length];
        return helper(days, costs, 0, memo);
    }
    public static void main(String[] args) {
        MinCostForTickets test=new MinCostForTickets();
        int[] arr={1,4,6,7,8,20};
        int[] costs={2,7,15};
        System.out.println(test.mincostTickets(arr, costs)); 
     }
}

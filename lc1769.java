//Minimum Number of Operations to Move All Balls to Each Box
public class lc1769 {
    public int[] minOperations(String boxes) {
        int[] dp=new int[boxes.length()];
        int front=0;
        int back=0;
        if(boxes.charAt(0)=='1')back++;
        /**If it take S steps to bring all n balls to box 0 it will take S-n ops at box 1 since all the balls 
         * will have to take 1step less to reach box 1;For boxes that are behind ith pos they will need to take +1 step.
         * SO at ith pos total ops is S-Tot_front_boxes+Tot_boxes_behind
          */
          //finding dp[0],i.e ops required to bring all balls to box 0.
      
        
          for(int i=1;i<boxes.length();i++){
              if(boxes.charAt(i)=='1'){
                  dp[0]+=i;
                  front++;
              }
          }
          for(int i=1;i<boxes.length();i++){
              dp[i]=dp[i-1]-front+back;
              if(boxes.charAt(i)=='1'){
                  back++;
                  front--;
              }
          }
          return dp;
        
    }
}

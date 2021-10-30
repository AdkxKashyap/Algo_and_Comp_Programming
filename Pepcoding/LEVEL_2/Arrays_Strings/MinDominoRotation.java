public class MinDominoRotation {
  //lc1007
  public static int minDominoRotations(int[] tops, int[] bottoms) {
    // write your code here
    int val1 = tops[0];
    int val2 = bottoms[0];
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    for(int i = 0; i < tops.length; i++) {
        //make top val1
        if(tops[i] != val1 && count1 != Integer.MAX_VALUE) {
            if(bottoms[i] == val1)count1++;
            else count1 = Integer.MAX_VALUE;
            //make top val2
        } if(tops[i] != val2 && count2 != Integer.MAX_VALUE) {
            if(bottoms[i] == val2) count2++;
            else count2 = Integer.MAX_VALUE;
            //make bottom val1
        } if(bottoms[i] != val1 && count3 != Integer.MAX_VALUE) {
            if(tops[i] == val1) count3++;
            else count3 = Integer.MAX_VALUE;
        } if(bottoms[i] != val2 && count4 != Integer.MAX_VALUE) {
            if(tops[i] == val2) count4++;
            else count4 = Integer.MAX_VALUE;
        }
    }
    int res = Math.min(Math.min(count1, count2), Math.min(count3, count4));
    return res == Integer.MAX_VALUE ? -1 : res;
  }

}

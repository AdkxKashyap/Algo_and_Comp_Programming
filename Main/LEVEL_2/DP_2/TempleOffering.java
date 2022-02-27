public class TempleOffering {
  public static int totaloffering(int[] height) {
		// write your code here
    int left = 0;
    int[] larr = new int[height.length];
    larr[0] = 1;
    for(int i = 1; i < height.length; i++) {
      if(height[i] > height[i-1]) {
        larr[i] = larr[i-1]+1;
      } 
       else {
        //reset left
        // left = 1;
        larr[i] = 1;
      }
    }

    //create right arr
    int[] rarr = new int[height.length];
    int right = 0;
    rarr[height.length-1] = 1;
    for(int i = height.length-2; i >= 0; i--) {
      if(height[i] > height[i+1]) {
        rarr[i] = rarr[i+1]+1;
      } 
       else {
        //reset right
        // right = 1;
        rarr[i] = 1;
      }
    }
    int res = 0;
    for(int i = 0; i < height.length; i++) {
      res += Math.max(larr[i], rarr[i]);
    }
		return res;
	}
}

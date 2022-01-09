public class MaxConsequtiveOnes1 {
  public static int solution(int[] arr) {
    // write your code here
    int i = -1;
    int j = -1;
    int countZ = 0;
    int ans = Integer.MIN_VALUE;
    //acquire
    for (int val : arr) {
      i++;
      if (val == 0)
        countZ++;
        //we can only flip one 0 so freq 0 > 1 release 0s 
      while (countZ > 1) {
        j++;
        if (arr[j] == 0)
          countZ--;
      }
      ans = Math.max(ans, i - j);
    }
    return ans == Integer.MIN_VALUE ? 0 : ans;
  }
}

public class MaxConsequtiveOnes2 {
  public static int solution(int[] arr, int k) {
    // write your code here
    int i = -1;
    int j = -1;
    int countZ = 0;
    int ans = Integer.MIN_VALUE;
    for (int val : arr) {
      i++;
      if (val == 0)
        countZ++;
      while (countZ > k) {
        j++;
        if (arr[j] == 0)
          countZ--;
      }
      ans = Math.max(ans, i - j);
    }
    return ans == Integer.MIN_VALUE ? 0 : ans;
  }
}

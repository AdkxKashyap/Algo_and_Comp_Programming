public class Rooftop {
  public static int findMaxSteps(int[] arr) {
    // write your code here
      int i = 0;
      int j = 1;
      int max = 0;
      while (j < arr.length) {
        int cnt = 0;
        while (j < arr.length && arr[j] > arr[i]) {
          cnt++;
          j++;
          i++;
        }
        max = Math.max(max, cnt);
        cnt = 0;
        i++;
        j++;
      }
      return max;

  }
}

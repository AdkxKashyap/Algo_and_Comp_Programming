import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MaxNonOverlappingBridge {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][2];
    for(int i = 0; i < n; i++) {
      arr[i][0] = sc.nextInt();
      arr[i][1] = sc.nextInt();
    }
    System.out.println(getMaxLength(arr));
  }

  public static int getMaxLength(int[][] arr) {
    int res = 0;
    //sort array according to north
    Arrays.sort(arr, new Comparator<int[]>() {
      @Override
    public int compare(int[] a, int[] b) {
      /**If two north are equal than the one has smaller south will come first */
      if(a[0] != b[0])
        return  a[0]-b[0];
      else {
        return a[1] - b[1];
      }
    }
      
    } );
    //lis of south. Now north and south both will be sorted in increasing order, so no overlapping.
    int[] dp = new int[arr.length];
    for(int i = 0; i < arr.length; i++) {
      //local max
      int max = 0;
      for(int j = 0; j < i; j++) {
        if(arr[j][1] <= arr[i][1]) {
          max = Math.max(max, dp[j]);
        }
      }
      dp[i] = max+1;
      res = Math.max(dp[i], res);
    }
    return res;
  }
}

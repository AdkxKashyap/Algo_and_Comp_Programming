import java.util.*;
import java.io.*;

public class Main {

  public static int minPages(int[]arr, int m) {
    //write your code here
    int max = Integer.MIN_VALUE;
    int sum;
    for(int val : arr) {
      max = Math.max(max, val);
      sum += val;
    }
    int lo = max;
    int hi = sum;
    int res = Integer.MAX_VALUE;
    while(lo <= hi) {
      int mid = lo + (hi-lo)/2;
      if(isPossible(arr, m, mid)) {
        res = mid;
        hi = mid-1;
      } else {
        lo = mid+1;
      }
    }
    return res;
  }
  public static boolean isPossible(int[] arr, int std, int load) {
    int sum = 0;
    int st = 1;
    for(int i = 0; i < arr.length; i++) {
      if(sum + arr[i] > load) {
        st++;
        sum = arr[i];
      } else {
        sum += arr[i];
      }
    }
    return st<=std;
  }
  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int m = scn.nextInt();

    int ans = minPages(arr, m);
    System.out.println(ans);
  }
}
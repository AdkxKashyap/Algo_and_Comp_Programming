import java.util.*;
import java.io.*;

public class Main {
//similar to allocate min pages
  public static int shipWithinDays(int[]arr, int days) {
    //write your code here
    int max = Integer.MIN_VALUE;
    int sum;
    for(int val : arr) {
      max = Math.max(max, val);
      sum += val;
    }
    int lo = max;
    int hi = sum;
    int res = 0;
    while(lo <= hi) {
      int mid = lo + (hi-lo)/2;
      if(isPossible(arr, days, mid)) {
        res = mid;
        hi = mid-1;
      } else {
        lo = mid+1;
      }
    }
    return res;
  }
  public static boolean isPossible(int[] arr, int days, int load) {
    int sum = 0;
    int d = 1;
    for(int i = 0; i < arr.length; i++) {
      if(sum + arr[i] > load) {
        d++;
        sum = arr[i];
      } else {
        sum += arr[i];
      }
    }
    return d<=days;
  }
  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int days = scn.nextInt();

    int ans = shipWithinDays(arr, days);
    System.out.println(ans);
  }
}
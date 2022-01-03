import java.util.*;
import java.io.*;
//https://practice.geeksforgeeks.org/problems/find-transition-point/1
public class Main {

  public static int findTransition(int[]arr) {
    //write your code here
    int tp = -1;
    int low = 0;
    int hi = arr.length-1;
    while(low <= hi) {
      int mid = (low+hi)/2;
      if(arr[mid] == 1) {
        tp = mid;
        hi = mid-1;
      } else {
        low = mid+1;
      }
    }
    return tp;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(findTransition(arr));
  }
}
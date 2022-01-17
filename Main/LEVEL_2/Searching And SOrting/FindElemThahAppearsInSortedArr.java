import java.util.*;
import java.io.*;

public class FindElemThahAppearsInSortedArr {

  public static int findSingleElement(int[]arr) {
    //write your code here
    int lo = 0;
    int hi = arr.length-1; 
    while(lo <= hi) {
      int mid = (lo + hi)/2;
      if(mid != 0 && arr[mid] == arr[mid-1]) {
        //find elem b/w lo & hi(excl hi)
        int ele = mid-lo;
        if(ele %2 == 0) {
          hi = mid-1;
        } else {
          lo = mid+1;
        }
      } else if(mid != arr.length-1 && arr[mid] == arr[mid+1]) {
        int ele = hi - mid;
        if(ele %2 == 0) {
          lo = mid+1;
        } else {
          hi = mid-1;
        }
      } else return arr[mid];
    }
    return 0;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int ans = findSingleElement(arr);
    System.out.println(ans);
  }
}
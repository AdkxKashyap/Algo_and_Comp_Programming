import java.util.*;
import java.io.*;

public class Main {

  public static int firstBadVersion(int n) {
    //write your code here
    int fbv = -1;
    int low = 0;
    int hi = n-1;
    while(low <= hi) {
      int mid = (low + hi)/2;
      if(isBadVersion(mid)) {
        //go left
        hi = mid-1;
        fbv = mid;
      } else {
        //go right
        low = mid+1;
      }
    }
    return fbv;
  }

  static int bad = 0;
  public static boolean isBadVersion(int val) {
    if (val >= bad) {
      return true;
    }
    else {
      return false;
    }
  }

  public static void solve(int n, int fbv) {
    bad = fbv;
    System.out.println(firstBadVersion(n));
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int fbv = scn.nextInt();

    solve(n, fbv);
  }
}
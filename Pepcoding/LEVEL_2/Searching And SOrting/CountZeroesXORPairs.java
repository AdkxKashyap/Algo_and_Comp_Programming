import java.util.*;
import java.io.*;

public class Main {
  public static int countPairs(int[]arr) {
    //write your code here
    //create fmap
    HashMap<Integer, Integer> fmap = new HashMap<>();
    for(int i = 0; i < arr.length; i++) {
      if(!fmap.containsKey(arr[i])) fmap.put(arr[i], 1);
      else {
        fmap.put(arr[i], fmap.get(arr[i]) + 1);
      }
    }
    int res = 0;
    for(int key : fmap.keySet()) {
      int val = fmap.get(key);
      res += ((val-1)* val)/2;
    }
    return res;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(countPairs(arr));
  }
}
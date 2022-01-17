package Main.LEVEL_2.Arrays_Strings;
import java.util.*;
//lc 41
public class FirstMissingPositive {


  //~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~~~
  public static int firstMissingPositive(int[] arr) {
    // write your code here
    boolean one = false;
    //mark out of range
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] == 1) one = true;
      //chosen 1 to mark out of range elements.Since we will return 1 anyways if 1 is not found.
      if(arr[i] < 1 ||  arr[i] > arr.length) arr[i] = 1;
    }
    if(one == false) return 1;
    for(int i = 0; i < arr.length; i++) {
      int idx = Math.abs(arr[i]);
      //marking negative
      arr[idx-1] = -Math.abs(arr[idx-1]);
    }

    //find positive element
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] > 0) return i+1;
    }
    return arr.length+1;
  }

  //~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int res = firstMissingPositive(arr);
    System.out.println(res);
  }
}
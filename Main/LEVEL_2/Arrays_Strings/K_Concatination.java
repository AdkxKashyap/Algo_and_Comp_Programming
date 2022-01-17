package Main.LEVEL_2.Arrays_Strings;
import java.io.*;
import java.util.*;

public class K_Concatination {

  public static int kadanes(int[] arr) {
    int gmax = arr[0];
    int max = arr[0];
    for(int i = 1; i < arr.length; i++) {
        if(max>=0) {
            max+=arr[i];
        }else {
            max = arr[i];
        }
        gmax = Math.max(gmax, max);
    }
    return gmax;
}
public static int kadanesForTwo(int[] arr) {
    int n = arr.length;
    int[] farr = new int[n*2];
    for(int i = 0; i < n; i++) {
        farr[i] = arr[i];
    }
    for(int i = 0; i < n; i++) {
        farr[n+i] = arr[i];
    }
    return kadanes(farr);
}
public static long solution(int[] arr, int k, long sum) {
// write your code here
    if(k == 1) return kadanes(arr);

    if(sum < 0) {
        return kadanesForTwo(arr);
    }else {
        return kadanesForTwo(arr) + (int)(k-2)*sum;
    }
}

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
      sum += arr[i];
    }
    int k = scn.nextInt();
    System.out.println(solution(arr, k, sum));
  }
}
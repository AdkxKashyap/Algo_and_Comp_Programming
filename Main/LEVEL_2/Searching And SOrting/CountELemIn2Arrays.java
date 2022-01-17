import java.util.*;
import java.io.*;

public class Main {

  public static int[] find(int[]arr1, int[]arr2) {
    //write your code here
    //create fmap
    int[] fmap = new int[100000];//max elem is 100000.See constraint
    for(int val : arr2) {
      ++fmap[val];
    }
    //prefix sum
    int sum = 0;
    for(int i = 0; i < fmap.length; i++) {
      sum += fmap[i];
      fmap[i] = sum;
    }
    for(int i = 0; i < arr1.length; i++) {
      arr1[i] = fmap[arr1[i]];
    }
    return arr1;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);

    int n1 = scn.nextInt();
    int[]a = new int[n1];

    for (int i = 0; i < n1; i++) {
      a[i] = scn.nextInt();
    }

    int n2 = scn.nextInt();
    int[]b = new int[n2];

    for (int i = 0; i < n2; i++) {
      b[i] = scn.nextInt();
    }

    int[]ans = find(a, b);

    for (int val : ans) {
      System.out.print(val + " ");
    }
  }
}
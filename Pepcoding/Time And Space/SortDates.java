import java.io.*;
import java.util.*;

public class Main {

  public static void sortDates(String[] arr) {
    // write your code here
    countSort(arr, 1000000, 100, 32);
    countSort(arr, 10000, 100, 13);
    countSort(arr, 1, 10000, 2501);
    print(arr);
  }

  public static void countSort(String[] arr, int div, int mod, int range) {
    // write your code here
    int[] farr = new int[range];
    // create the farr
    for (int i = 0; i < arr.length; i++) {
      // see notes for formula
      // Use 10 because days are like 05,06.Compiler treats them as hexadecimal force
      // it to use binary.See video
      int idx = Integer.parseInt(arr[i], 10) / div % mod;
      farr[idx]++;
    }
    // prefix sum
    for (int i = 1; i < range; i++) {
      farr[i] = farr[i - 1] + farr[i];
    }
    // place each element
    String[] ans = new String[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      int idx = farr[Integer.parseInt(arr[i], 10) / div % mod] - 1;
      farr[Integer.parseInt(arr[i], 10) / div % mod]--;
      ans[idx] = arr[i];
    }
    for (int i = 0; i < arr.length; i++) {
      arr[i] = ans[i];
    }
  }

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = str;
    }
    sortDates(arr);
    print(arr);
  }

}
import java.util.*;
import java.io.*;

public class Main {

  /*
   * You have to complete union function and return an Arraylist which contains
   * union elements of the two arrays
   */
  public static ArrayList<Integer> union(int[] a, int[] b) {
    // write your code here
    ArrayList<Integer> res = new ArrayList<>();
    int i = 0;
    int j = 0;
    while (i < a.length && j < b.length) {
      if (res.size() != 0) {
        if (a[i] == b[j]) {
          if (res.get(res.size() - 1) != a[i]) {
            res.add(a[i]);
          }
          i++;
          j++;
        } else if (a[i] < b[j]) {
          if (res.get(res.size() - 1) != a[i])
            res.add(a[i]);
          i++;
        } else {
          if (res.get(res.size() - 1) != b[j])
            res.add(b[j]);
          j++;
        }
      } else {
        if(a[i] != b[j]) {
          if(a[i] < b[j]) {
            res.add(a[i]);
            i++;
          } else if(a[i] > b[j]) {
            res.add(b[j]);
            j++;
          }
        } else {
          res.add(a[i]);
          i++;
          j++;
        }
      }
    }
    while(i < a.length) {
      if(res.get(res.size()-1) != a[i])
        res.add(a[i]);
      i++;
    }
    while(j < b.length) {
      if(res.get(res.size()-1) != b[j])
        res.add(b[j]);
      j++;
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    // input work
    int n = scn.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scn.nextInt();
    }

    int m = scn.nextInt();
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = scn.nextInt();
    }

    ArrayList<Integer> ans = union(a, b);

    // print answer list
    for (int val : ans) {
      System.out.print(val + " ");
    }
    System.out.println();
  }
}
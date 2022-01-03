import java.util.*;
import java.io.*;

public class Main {

  public static int count(int[]arr) {
    //write your code here
    // Arrays.sort(arr);
    int i = 0; 
    int j = arr.length-1;
    int cnt = 0;
    int next = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;
    while(i <= j) {
        int val1 = Math.abs(arr[i]);
        int val2 = Math.abs(arr[j]);
        if(val1 < val2) {
            if(val2 != next) cnt++;
            next = val2;
            j--;
        }else if(val1 > val2) {
            if(val1 != prev) cnt++;
            prev = val1;
            i++;
        } else if(val1 == val2) {
           if(val1 != prev && val2 != next) cnt++;
            i++;
            j--;
            prev = val1;
            next = val2;
        }
    }
    return cnt;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(count(arr));
  }
}
package Main.LEVEL_2.Arrays_Strings;
import java.util.*;

public class MaximumSwap {

  // ~~~~~~~~~~User Section~~~~~~~~~~~
  public static String maximumSwap(String num) {
    // write your code here
    int[] li = new int[10];
    char[] arr = num.toCharArray();
    for(int i = 0; i < arr.length; i++) {
        int digit = arr[i] - '0';
        li[digit] = i;
    }
    boolean flag = false;
    for(int i = 0; i < arr.length; i++) {
        int digit = arr[i] - '0';
        int j = 9;
        while(j > digit) {
            if(i < li[j]) {
                swap(arr, i, li[j]);
                flag = true;
                break;
            }
            j--;
        }
        if(flag) break;
    }
    return new String(arr);
  }
  public static void swap(char[] arr,int i, int j) {
      if(i == j) return;
      char tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
  }

  // ~~~~~~~~Input Management~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    String ans = maximumSwap(str);
    System.out.println(ans);
  }
}
import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
    // write code here   
    //find max val
    int max = Integer.MIN_VALUE;
    for(int val:arr) max = Math.max(max, val);
    int exp = 1;
    while(exp <= max) {
      countSort(arr, exp);
      exp = exp*10;
    } 
  }

  public static void countSort(int[] arr, int exp) {
    // write code here
    //here we are taking 10 bcz digits will be from 0-9 only.
   int[] farr = new int[10];
   //create the farr
   for(int i = 0; i < arr.length; i++) {
     //we need to sort digitwise
     int idx = arr[i]/exp%10;
     farr[idx]++;
   }
   //prefix sum
   for(int i = 1; i < 10; i++) {
     farr[i] = farr[i-1]+farr[i];
   }
   //place each element
   int[] ans = new int[arr.length];
   for(int i = arr.length-1; i >= 0; i--) {
     int idx = farr[arr[i]/exp%10]-1;
     farr[arr[i]/exp%10]--;
     ans[idx] = arr[i];
   }
   for(int i = 0; i < arr.length; i++) {
       arr[i] = ans[i];
   }
    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}
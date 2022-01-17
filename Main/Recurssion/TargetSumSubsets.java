package Main.Recurssion;

import java.util.Scanner;

public class TargetSumSubsets {
  public static void main(String[] args) throws Exception {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<arr.length;i++){
      arr[i]=sc.nextInt();
    }
    int tar=sc.nextInt();
    printTargetSumSubsets(arr,0,"",tar) ;
  }

  // set is the subset
  // sos is sum of subset
  // tar is target
  public static void printTargetSumSubsets(int[] arr, int idx, String set, int tar) {
    if(tar<0)return;
    for(int i=idx;i<arr.length;i++){
      printTargetSumSubsets(arr, i+1, set+""+arr[i]+", ", tar-arr[i]);
    }
    if(tar==0){
      System.out.println(set);
    }
  }
}

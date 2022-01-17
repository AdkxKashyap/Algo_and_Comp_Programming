import java.util.*;
import java.io.*;

public class Main {
  public static int largestPerimeter(int[]nums) {
    //write your code here
    //s1 + s2 > s3, s2 + s3 > s1, s1 + s3 > s2, in sorted arr s1<s2<s3 so only find s1+s2<s3
    Arrays.sort(nums);
    int n = nums.length;
    for(int i = n-3; i >= 0; i--) {
      int s1 = nums[i];
      int s2 = nums[i+1];
      int s3 = nums[i+2];
      if(s1 + s2 > s3) return s1+s2+s3;
    }
    return 0;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]nums = new int[n];

    for (int i = 0; i < n; i++) {
      nums[i] = scn.nextInt();
    }

    System.out.println(largestPerimeter(nums));
  }
}
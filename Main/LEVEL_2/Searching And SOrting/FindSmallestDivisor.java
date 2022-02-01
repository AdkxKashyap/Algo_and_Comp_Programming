import java.util.*;
import java.io.*;
//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
public class Main {
    public static int findSmallestDivisor(int[]nums,int th) {
        //write your code here
         //write your code here
        //find max 
        int max = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
          max = Math.max(max, nums[i]);
        }
        int lo = 0;
        int hi = max;
        int res = 0;
        while(lo <= hi) {
          int mid = lo + (hi-lo)/2;
          if(isPossible(nums, th, mid)) {
            //update res
            res = Math.min(res, mid);
            //decrease speed
            hi = mid-1;
          } else {
            lo = mid+1;
          }
        }
        return res;
    }
    public static boolean isPossible(int[] nums, int h, int d) {
      int sum = 0;
      for(int i = 0; i < nums.length; i++) {
        sum += (int)Math.ceil((nums[i] * 1.0)/d);
      }
      if(sum <= h) return true;
      return false;
    }
    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]nums = new int[n];

        for(int i=0 ; i < n ; i++) {
            nums[i] = scn.nextInt();
        }

        int th = scn.nextInt();

        int speed = findSmallestDivisor(nums,th);
        System.out.println(speed);
    }
}
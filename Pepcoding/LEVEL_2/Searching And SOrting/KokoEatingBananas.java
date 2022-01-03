import java.util.*;
import java.io.*;

public class Main {
    public static int minEatingSpeed(int[]piles,int h) {
        //write your code here
        //find max bananas
        int max = Integer.MAX_VALUE;
        for(int i = 0; i < piles.length; i++) {
          max = Math.max(max, piles[i]);
        }
        int lo = 0;
        int hi = max;
        int res = 0;
        while(lo <= hi) {
          int mid = lo + (hi-lo)/2;
          if(isPossible(piles, h, mid)) {
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
    public static boolean isPossible(int[] piles, int h, int sp) {
      int time = 0;
      for(int i = 0; i < piles.length; i++) {
        time += (int)Math.ceil((piles[i] * 1.0)/sp);
      }
      if(time <= h) return true;
    }
    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]piles = new int[n];

        for(int i=0 ; i < n ; i++) {
            piles[i] = scn.nextInt();
        }

        int h = scn.nextInt();

        int speed = minEatingSpeed(piles,h);
        System.out.println(speed);
    }
}
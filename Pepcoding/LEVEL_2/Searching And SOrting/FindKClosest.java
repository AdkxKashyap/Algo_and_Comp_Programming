import java.util.*;
import java.io.*;

public class Main {

    /*find 'k' closest element to 'x' and return answer list*/
    /*elements in answer list should be in ascending order*/
    public static ArrayList<Integer> findClosest(int[]arr,int k,int x) {
        //write your code here
        //apply bs
        int low = 0;
        int mid = -1;
        int hi = arr.length-1;
        while(low <= hi) {
           mid = (low+hi)/2;
          if(arr[mid] == x) break;
          else if(arr[mid] > x) hi = mid-1;
          else if(arr[mid] < x) low = mid+1;
        }
        //edge case, see leetcode 658
        int l; int r;
        if(mid == 0) {
          l = mid;
          r = mid+1;
        } else {
          l = mid-1;
          r = mid;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while(l >= 0 && r < arr.length && k > 0) {
          int lres = Math.abs(x-arr[l]);
          int rres = Math.abs(x-arr[r]);
          if(lres <= rres) {
            res.add(arr[l]);
            l--;
          } else {
            res.add(arr[r]);
            r++;
          }
          k--;
        }

        //edge case where k != 0 & above loop end bcoz l = 0 or r = end
        while(k > 0 && l >= 0) {
          res.add(arr[l]);
          l--;
          k--;
        }
        while(k > 0 && r < arr.length) {
          res.add(arr[r]);
          r++;
          k--;
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[]args) {

        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        int x = scn.nextInt();

        ArrayList<Integer>ans = findClosest(arr,k,x);

        for(int val : ans) {
            System.out.print(val + " ");
        }

    }
}
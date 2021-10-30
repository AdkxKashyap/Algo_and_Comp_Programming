import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0) System.out.println(0);
        int[] arr = new arr[n];
        for(int i = 0; i < n; i++) {
          arr[i] = sc.nextInt();
        }
        int gMax = arr[0];
        // int gMin = arr[0];
        int max = arr[0];
        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
          max = Math.max(arr[i], Math.max(arr[i] * max, arr[i] * min));
          min = Math.min(arr[i], Math.min(arr[i] * max, arr[i] * min));

          gMax = Math.max(gMax, max);
        }
        System.out.println(gMax);
    }
}
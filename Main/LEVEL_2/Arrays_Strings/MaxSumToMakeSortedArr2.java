package Main.LEVEL_2.Arrays_Strings;
import java.util.*;

public class MaxSumToMakeSortedArr2 {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted2(int[] arr) {
        // write your code here
         int chunks = 0;
        int j =arr.length-1;
        //prep right min
        int[] rmin = new int[arr.length+1];
        rmin[arr.length] = Integer.MAX_VALUE;
        for(int i = arr.length-1; i >= 0; i--) {
            rmin[i] = Math.min(rmin[i+1], arr[i]);
        }
        //solve max chunks
        int leftmax = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            leftmax = Math.max(leftmax, arr[i]);
            if(leftmax <= rmin[i+1]) chunks++;
        }
        return chunks;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}
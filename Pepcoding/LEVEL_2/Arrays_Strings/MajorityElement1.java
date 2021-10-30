package Arrays_Strings;

import java.util.*;

public class MajorityElement1 {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
    public static int findVal(int[] arr) {
        int count = 1;
        int value = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == value) count++;
            else count--;
            if(count == 0) {
                value = arr[i];
                count = 1;
            }
        }
        return value;
    }
    public static void printMajorityElement(int[] arr) {
        // write your code here
        int value = findVal(arr);
        int c = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == value) c++;
        }
        if(c > arr.length/2) System.out.println(value);
        else System.out.println("No Majority Element exist");
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        printMajorityElement(arr);
    }
}
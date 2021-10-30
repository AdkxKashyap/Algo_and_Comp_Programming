import java.io.*;
import java.util.*;

public class K_Partitions {
    public static int Counter = 1;
    public static void kPartitions(ArrayList<Integer>[] arr, int val,int n, int k, int subsetsUsed) {
        if(val > n) {
            if(subsetsUsed == k) {
                System.out.print(Counter + ". ");
                for(ArrayList<Integer> list : arr) {
                    System.out.print(list + " ");
                }
                Counter++;
                System.out.println();
            }
            return;
        }
        //add ith element in an existing subset
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].size() > 0) {
                arr[i].add(val);
                kPartitions(arr,val + 1, n, k, subsetsUsed);
                arr[i].remove(arr[i].size() - 1);
            }
        }
        //create a new subset and add it
        if(subsetsUsed < k) {
            arr[subsetsUsed].add(val);
            kPartitions(arr,val + 1, n, k, subsetsUsed + 1);
            arr[subsetsUsed].remove(arr[subsetsUsed].size() - 1);
        }
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int k = sc.nextInt();
	    ArrayList<Integer>[] arr = new ArrayList[k];
	    for(int i = 0; i < k; i++) {
	        arr[i] = new ArrayList<>();
	    }
	    kPartitions( arr, 1, n, k, 0);
	}
}
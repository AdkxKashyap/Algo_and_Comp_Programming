package Heaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class KLargest {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
       arr[i] = Integer.parseInt(br.readLine());
    }

    int k = Integer.parseInt(br.readLine());
    // write your code here
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    //add first k elements 
    for(int i = 0; i < k; i++){
      pq.add(arr[i]);
    }

    for(int i = k; i < arr.length; i++){
      /**peek() will give current min in heap.if arr[i] is < than peek() than it will not be added to max elements */
      if(arr[i] > pq.peek()){
        pq.remove();
        pq.add(arr[i]);
      }
    }
    while(pq.size() > 0){
      System.out.println(pq.remove());
    }
  }
}

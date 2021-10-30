package Hashmaps;

import java.util.*;

public class LCS {
  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner in = new Scanner(System.in);
    int n1 = in.nextInt();
    int[] arr1 = new int[n1];
    for(int i = 0; i < arr1.length; i++){
      arr1[i] = in.nextInt();
    }
    printLcs(arr1);
 }
  public static void printLcs(int[] arr){

    //set starting point.An element i is a starting point,if i-1 is not present in map
    HashMap<Integer, Boolean> map = new HashMap<>();
    for(int key : arr){
      map.put(key, true);
    }
    
    for(int key : arr){
      if(map.containsKey(key - 1) == true)
        map.put(key, false);
    }
    
    int maxlen = 0;
    int start = 0;
    for(int key : map.keySet()){
      if(map.get(key) == true){
        int len = 1;
        int st =  key;
        while(map.containsKey(key + 1) == true){
          len++;
          key++;
        }
        if(len > maxlen){
          maxlen = len;
          start = st;
        }
      }
    }
    //print
    for(int i = 0 ; i < maxlen; i++){
      System.out.println(start);
      start ++;
    }
    
  }
}

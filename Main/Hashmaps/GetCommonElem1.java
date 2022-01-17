package Main.Hashmaps;

import java.util.*;

public class GetCommonElem1 {
  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner in = new Scanner(System.in);
    int n1 = in.nextInt();
    int[] arr1 = new int[n1];
    for(int i = 0; i < arr1.length; i++){
      arr1[i] = in.nextInt();
    }

    int n2 = in.nextInt();
    int[] arr2 = new int[n2];
    for(int i = 0; i < arr2.length; i++){
      arr2[i] = in.nextInt();
    }
    printCommonElem(arr1, arr2);
 }
 public static void printCommonElem(int[] arr1, int[] arr2){
  //prepare map for arr1 elements
  HashMap<Integer, Integer> hm1 = new HashMap<>();
 for(int key : arr1) hm1.put(key, 1);

 //for arr2
//   HashMap<Integer, Integer> hm2 = new HashMap<>();
 for(int key : arr2){
   if(hm1.containsKey(key)){
     System.out.println(key);
     hm1.remove(key);
   }
 }
}
}

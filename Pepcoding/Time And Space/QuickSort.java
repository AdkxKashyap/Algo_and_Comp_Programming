import java.util.*;
public class QuickSort {
  public static int partition(int[] arr, int low, int high) {
    int pivot = arr[low];
    int i = low;
    int j = high;
    while(i < j) {
      do {
        i++;
      }while(arr[i] <= pivot);
      do {
        j--;
      }while(arr[j] > pivot);

      if(i < j) {
        // arr[i] = arr[i] + arr[j];
        //  arr[j] = arr[i] - arr[j];
        //  arr[i] = arr[i] - arr[j]; 
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
     }
    }
    int tmp = arr[low];
        arr[low] = arr[j];
        arr[j] = tmp;
    return j;
  }
  public static void qs(int[] arr, int low, int high) {
    if(low < high) {
      int pivot  = partition(arr, low, high);
      qs(arr, low, pivot);
      qs(arr, pivot + 1, high);
    }
  }
 public static void main(String[] args) {
   int[] arr = {10, 16, 7, 3,Integer.MAX_VALUE};
   qs(arr, 0, arr.length-1);
   for(int i : arr) System.out.println(i + ",");
 } 
}

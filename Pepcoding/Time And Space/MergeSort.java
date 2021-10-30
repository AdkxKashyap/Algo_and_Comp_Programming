public class MergeSort {
  public static void sort(int[] arr, int low, int high) {
    if(low < high) {
      int mid = low + (high-low)/2;
      sort(arr, low, mid);
      sort(arr, mid+1, high);
      merge(arr, low, mid, high);
    }
  }
  public static void merge(int[] arr, int low, int mid, int high) {
    int n1 = mid - low + 1;
    int n2 = high - mid;
    int[] L = new int[n1];
    int[] R = new int[n2];
    //copy data
    for(int i = 0; i < n1; i++) {
      L[i] = arr[low + i];
    }
    for(int i = 0; i < n1; i++) {
      R[i] = arr[mid + i + 1];
    }
    int k = low;
    int i = 0, j = 0;
    while(i < n1 && j < n2) {
      if(L[i] < R[j]) {
        arr[k] = L[i];
        i++;
      }
      else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }
    while(i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }
    while(j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }
  public static void main(String[] args) {
    int[] arr = {10,16,7,3};
    sort(arr, 0, arr.length-1);
    for(int i : arr) System.out.println(i);
  }
}

public class binarySearch {
  public static boolean binarySearchRec(int[] arr, int lo, int hi, int data) {
    if(lo>hi){
      return false;
    }
      int mid=(lo+hi)/2;
      if(arr[mid]==data)return true;
      if(arr[mid]<data){
        return binarySearchRec(arr, mid+1, hi, data);
      }
      else{
        return binarySearchRec(arr, lo, mid-1, data);
      }
  }
  public static void main(String[] args) {
    int[] arr = { 1, 2, 5, 6, 7, 8, 9, 10, 15, 16 };
    boolean res=binarySearchRec(arr, 0, arr.length-1, 15);
    System.out.println(res);
  }
  

}

import java.util.Arrays;

class TargetSumPair {
  public static void targetSumPair(int[] arr, int target){
    //write your code here
    Arrays.sort(arr);
    int i = 0;
    int j = arr.length-1;
   while(i < j) {
       if(arr[i] + arr[j] > target) j--;
       else if(arr[i] + arr[j] < target) i++;
       else {
           System.out.println(arr[i] + ", " + arr[j]);
           i++;
           j--;
       }
   }
 }

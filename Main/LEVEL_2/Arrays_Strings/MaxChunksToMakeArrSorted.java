package Main.LEVEL_2.Arrays_Strings;
public class MaxChunksToMakeArrSorted {
  public static int maxChunksToSorted2(int[] arr) {
    // write your code here
    //arr contains elem from 0 to arr.len-1
    int chunks = 0;
    int max = Integer.MIN_VALUE;
    
    for(int i = 0; i < arr.length; i++) {
      max = Math.max(arr[i], max);
      if(max == i) {
        chunks++;
      }
    }
    return chunks;
}
}

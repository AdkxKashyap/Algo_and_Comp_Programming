public class MaxChunksToMakeArraySOrted2 {
  public static int maxChunksToSorted2(int[] arr) {
    // write your code here
    int chunks = 1;
    int rMin[] = new int[arr.length];
    int min = Integer.MAX_VALUE;
    //create right min arr
    for(int i = arr.length-1; i >= 0; i--) {
      min = Math.min(arr[i], min);
      rMin[i] = min;
    }
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < arr.length-1; i++) {
      max = Math.max(arr[i], max);
      if(max <= rMin[i+1]) {
        chunks++;
      }
    }
    return chunks;
  }
}

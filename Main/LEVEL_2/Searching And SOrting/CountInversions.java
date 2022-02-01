public class CountInversions {
    public static int  count = 0;
    static int inversionCount(int arr[], int N)
    {
        // Your Code Here
         mergesort(arr, 0, N-1);
         return count;
    }

    static int[] mergesort(int[] arr, int lo, int hi) {
      if(lo == hi) {
        int[] ret = new int[1];
        ret[0] = arr[(int) lo];
        return ret;
    }
      int mid = lo+(hi-lo)/2;

      int[] left = mergesort(arr, lo, mid);
      int[] right = mergesort(arr, mid+1, hi);

      return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
      int[] res = new int[left.length+right.length];
      int i = 0;
      int j = 0;
      int k = 0;
/**eg l=[4,5,6] r=[1,2,3]
 * if i is at 0 and j is at 0
 * count+=3 since 4 > 1,2,3
*/
      while(i < left.length && j < right.length) {
        if(left[i] <= right[j]) {
          res[k++] = left[i];
          i++;
        } else {
          res[k++] = right[j];
          count+=(left.length-i);
          j++;
        }
      }
      while(i < left.length) {
        res[k++] = left[i];
        i++;
      }
      while(j < right.length) {
        res[k++] = right[j];
        j++;
      }
      return res;
    }
    
}

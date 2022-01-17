package Main.LEVEL_2.Arrays_Strings;
public class FirstNegativeInKWindow {
  //https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
  public long[] printFirstNegativeInteger(long A[], int N, int K)
  {
      int indx = N;
      long[] res = new long[(N-K)+1];
      for(int i = N-1; i >= N-K; i--) {
          if(A[i] < 0) indx = i;
      }
      for(int i = N-K; i >= 0; i--) {
          if(A[i] < 0) indx = i;
          if(indx < i+K) {
              res[i] = A[indx];
          }
      }
      return res;
  }
}

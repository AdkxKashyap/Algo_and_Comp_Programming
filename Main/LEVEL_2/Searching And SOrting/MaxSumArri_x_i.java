import java.util.Arrays;

public class MaxSumArri_x_i {
  int Maximize(int arr[], int n)
  {
      // Complete the function
      Arrays.sort(arr);
      long sum = 0;
      for(int i = 0; i < n; i++) {
          sum += arr[i]*i;
      }
      return (int)sum;
      
  }   
}

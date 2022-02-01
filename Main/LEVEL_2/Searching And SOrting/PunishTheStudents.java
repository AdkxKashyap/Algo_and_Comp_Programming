class Solution
{
    public static int shouldPunish (int roll[], int marks[], int n, double avg)
    {
        // your code here
        //1. - Find total swaps Require using bubble sort.We need to find total swaps not nim swaps
        int swaps = findSwaps(roll, n);
        //2. - Sum(Marks of all stds) - total swaps
        int sum = 0;
        for(int i = 0; i < n; i++) {
          sum += marks[i];
        }
        //3. - Find Avg
        int nmarks = sum - swaps;
        if(nmarks*1.0/n > avg) return 1;
        else return 0;
    }
    public static int findSwaps(int[] arr, int n) {
      int cnt = 0;
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < n-i-1; j++) {
          if(arr[j] > arr[j+1]) {
            cnt++;
          }
        }
      }
      return cnt;
    }
}
import java.util.HashSet;

public class LongestSubarrWithContiguousElem {
  public static int solution(int[] arr) {
		// write your code here
    int ans = 0;
    for(int i = 0; i < arr.length-1; i++) {
      HashSet<Integer> set = new HashSet<>();
      set.add(arr[i]);
      int max = arr[i];
      int min = arr[i];
      for(int j = i+1; j < arr.length; j++) {
        if(set.contains(arr[j])) break;
        set.add(arr[j]);
        max = Math.max(max, arr[j]);
        min = Math.min(min, arr[j]);
        if(max-min == j-i) {
          int len = j-i+1;
          ans = Math.max(ans, len);
        }
      }
    }
		return ans;
	}
}

import java.util.HashSet;

public class PairsWithEqualSum {
  public static boolean solution(int[] arr) {
    // write your code here
    HashSet<Integer> set = new HashSet<>();
    for(int i = 0; i < arr.length; i++) {
      for(int j = i+1; j < arr.length; j++) {
        int sum = arr[i]+arr[j];
        if(set.contains(sum)) return true;
        set.add(sum);
      }
    }
    return false;
}

}

import java.util.HashMap;
import java.util.HashSet;

public class PairsWithGivenSumInTwoSortedMatrix {
  // not using the map approach O(N) space. This is the O(1) space soln.
  // 1 test case not workin
  public static int solve(int[][] num1, int[][] num2, int k) {
    // write your code here
    int n = num1.length;
    int ans = 0;
    int i = 0;
    int j = n * n - 1;
    while (i < n * n && j >= 0) {
      int r1 = i / n;
      int c1 = i % n;
      int r2 = j / n;
      int c2 = j % n;

      int v1 = num1[r1][c1];
      int v2 = num2[r2][c2];
      int sum = v1 + v2;
      if (sum == k) {
        ans++;
        // check next cell has same values
        i++;
        j--;

        // while (i < n * n && j >= 0 && (num1[i / n][i % n] == v1 || num2[j / n][j % n] == v2)) {
        //   ans++;
        //   if (num1[i / n][i % n] == v1)
        //     i++;
        //   if (num2[j / n][j % n] == v2)
        //     j--;
        // }
      }
      if (sum > k)
        i++;
      else
        j--;
    }
    return ans;
  }

  // hmap solution
  public static int solve2(int[][] num1, int[][] num2, int k) {
    int count = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < num1.length; i++) {
      for(int j = 0; j < num1[0].length; j++) {
        int val = num1[i][j];
        //to manage duplicate elements.The pairs need not be distinct. See eg test case
        map.put(val, map.getOrDefault(val, map.get(val)+1));
      }
    }

    for(int i = 0; i < num2.length; i++) {
      for(int j = 0; j < num2[0].length; j++) {
        int val = num2[i][j];
        //to manage duplicate elements.The pairs need not be distinct. See eg test case
        if(map.containsKey(k-val)) count+=map.get(val);
      }
    }
    return count;
  }
}

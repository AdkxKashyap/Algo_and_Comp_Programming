package Main.LEVEL_2.Graph;
import java.io.*;
import java.util.*;

public class MinSwapsToSort {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    String[] st = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st[i]);
    }

    System.out.println(minSwaps(arr));
  }

  public static int minSwaps(int[] arr1) {
    // pos ->[arr[i]][i]
    int[][] pos = new int[arr1.length][2];
    for (int i = 0; i < arr1.length; i++) {
      pos[i][0] = arr1[i];
      pos[i][1] = i; // store original pos
    }
    // sort pos array
    Arrays.sort(pos, (a, b) -> a[0] - b[0]);
    int ans = 0;

    int[] vis = new int[pos.length];
    for (int i = 0; i < pos.length; i++) {
      if (vis[i] == 1 || i == pos[i][1]) {
        // if vis or elem in its original pos no swap reqd
        continue;
      }

      int j = i;
      int count = 0;
      // detect cycle
      while (vis[j] == 0) {
        vis[j] = 1;
        count++;
        j = pos[j][1];
      }
      ans += (count - 1);
    }
    return ans;
  }
}

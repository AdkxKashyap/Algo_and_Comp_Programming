import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DetectNegCycle {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);
    int[][] arr = new int[m][3];
    for (int i = 0; i < m; i++) {
      st = br.readLine().split(" ");
      arr[i][0] = Integer.parseInt(st[0]);
      arr[i][1] = Integer.parseInt(st[1]);
      arr[i][2] = Integer.parseInt(st[2]);
    }
    int[] path = new int[n];
    Arrays.fill(path, Integer.MAX_VALUE);
    // v-1 iteration
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < m; j++) {
        int u = arr[j][0];
        int v = arr[j][1];
        int wt = arr[j][2];
        if (path[u] != Integer.MAX_VALUE && path[u] + wt < path[v]) {
          path[v] = path[u] + wt;
        }
      }
    }
    // vth iteration
    for (int j = 0; j < m; j++) {
      int u = arr[j][0];
      int v = arr[j][1];
      int wt = arr[j][2];
      if (path[u] != Integer.MAX_VALUE && path[u] + wt < path[v]) {
        System.out.println(1);
        return;
      }
    }
    System.out.println(0);
  }
}

package Main.LEVEL_2.Graph;
import java.util.*;

public class MinCostToConnectAllPoints {
  public int find(int[] par, int e) {
    if (par[e] == e)
      return e;
    int tmp = find(par, par[e]);
    par[e] = tmp;
    return tmp;
  }

  public void union(int[] par, int[] rank, int lx, int ly) {
    if (rank[lx] > rank[ly]) {
      par[ly] = lx;
    } else if (rank[lx] < rank[ly]) {
      par[lx] = ly;
    } else {
      par[ly] = lx;
      rank[lx]++;
    }
  }

  // Using Kruskals,We can also use prims
  public int minCostConnectPoints(int[][] coords) {
    int n = coords.length;
    int size = n * (n-1) / 2;
    // First we need to find manhattan distance of coords
    // each point -> u,v,wt
    int[][] points = new int[size][3];
    int indx = 0;
    // find manhattan distance
    for (int i = 0; i < coords.length; i++) {
      for (int j = i + 1; j < coords.length; j++) {
        int x1 = coords[i][0];
        int y1 = coords[i][1];
        int x2 = coords[j][0];
        int y2 = coords[j][1];
        int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
        points[indx][0] = i;
        points[indx][1] = j;
        points[indx][2] = dist;
        indx++;
      }
    }
    Arrays.sort(points, (val1, val2) -> val1[2] - val2[2]);

    // Apply Union find on points
    int[] par = new int[n];
    int[] rank = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      par[i] = i;
      rank[i] = 1;
    }
    for (int i = 0; i < size; i++) {
      int x = points[i][0];
      int y = points[i][1];
      int wt = points[i][2];
      int lx = find(par, x);
      int ly = find(par, y);
      if (lx != ly) {
        sum += wt;
        union(par, rank, lx, ly);
      }
    }
    return sum;
  }
}

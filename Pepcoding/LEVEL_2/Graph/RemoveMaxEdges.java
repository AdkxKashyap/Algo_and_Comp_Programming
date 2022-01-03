import java.io.*;
import java.util.*;

//DSU
public class RemoveMaxEdges {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] edges = new int[m][3];
    for (int i = 0; i < m; i++) {
      st = br.readLine().split(" ");
      edges[i][0] = Integer.parseInt(st[0]);
      edges[i][1] = Integer.parseInt(st[1]);
      edges[i][2] = Integer.parseInt(st[2]);
    }
    Main obj = new Main();
    System.out.println(obj.maxNumEdgesToRemove(n, edges));
  }

  public int maxNumEdgesToRemove(int n, int[][] edges) {
    //sort edges. We will first take edges where both 1 and 2 can use it
    Arrays.sort(edges, (a,b) -> b[0]-a[0]);
    int[] par_1 = new int[n + 1];
    int[] par_2 = new int[n + 1];
    int[] rank_1 = new int[n + 1];
    int[] rank_2 = new int[n + 1];
    // count is needed to check all vertices are reached.
    int count_1 = 1;
    int count_2 = 1;
    int remove = 0;
    for (int i = 0; i <= n; i++) {
      par_1[i] = i;
      par_2[i] = i;
      rank_1[i] = 1;
      rank_2[i] = 1;
    }
    for (int i = 0; i < edges.length; i++) {
      if (edges[i][0] == 3) {
        boolean temp_1 = union(edges[i][1], edges[i][2], par_1, rank_1);
        boolean temp_2 = union(edges[i][1], edges[i][2], par_2, rank_2);
        if (temp_1 == true)
          count_1++;
        if (temp_2 == true)
          count_2++;
        if (temp_1 == false && temp_2 == false)
          remove++;
      } else if (edges[i][0] == 1) {
        boolean temp_1 = union(edges[i][1], edges[i][2], par_1, rank_1);
        if (temp_1 == true)
          count_1++;
        else
          remove++;
      } else {
        boolean temp_2 = union(edges[i][1], edges[i][2], par_2, rank_2);
        if (temp_2 == true)
          count_2++;
        else
          remove++;
      }

    }
    if (count_1 != n || count_2 != n) {
      // check if all vertices can be reached
      return -1;
    }
    return remove;

  }

  public static boolean union(int x, int y, int[] parent, int[] rank) {
    int lx = find(x, parent);
    int ly = find(y, parent);
    if (lx != ly) {
      if(rank[lx] > rank[ly]) {
        parent[ly] = lx;
      }else if(rank[ly] > rank[lx]) {
        parent[lx] = ly;
      } else {
        parent[ly] = lx;
        rank[lx] ++;
      }
      return true;
    }
      return false;
  }

  public static int find(int x, int[] parent) {
    if (parent[x] == x)
      return x;
    int tmp = find(parent[x], parent);
    parent[x] = tmp;
    return tmp;
  }
}
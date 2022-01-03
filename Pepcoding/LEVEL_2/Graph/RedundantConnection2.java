import java.util.Arrays;

class Solution {
  static int[] parent;
  static int[] rank;
  int bl1 = -1; // blacklisted edge, edges due to which a node has two parent
  int bl2 = -1;

  public int[] findRedundantDirectedConnection(int[][] edges) {
    int n = edges.length;
    parent = new int[n];
    rank = new int[n];
    int indegree[] = new int[n];
    Arrays.fill(indegree, -1);
    for (int i = 0; i <= n; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
    // find indegree
    for (int i = 0; i < n; i++) {
      int v = edges[i][1];
      if (indegree[v] != -1) {
        bl1 = i;
        bl2 = indegree[v];
      } else {
        indegree[v] = i;
      }
    }
    for (int i = 0; i <= n; i++) {
      if (i == bl1)
        continue;
      // there are three cases
      int u = edges[i][0];
      int v = edges[i][1];
      boolean flag = union(u, v);
      if (flag) {
        if (bl1 == -1) {
          // case-1 : only cycle is present
          return edges[i];
        } else {
          //case - 3 : cyccle + 2 parents. Since we blk listed edge i(bl1) bl2 is causing the cycle
          return edges[bl2]; 
        }
      }
    }
    //case 2 : no cycle, only 2 parents 
    return edges[bl2];
  }

  public static boolean union(int x, int y) {
    int lx = find(x);
    int ly = find(y);
    if (lx != ly) {
      if (rank[lx] > rank[ly]) {
        parent[ly] = lx;
      } else if (rank[ly] > rank[lx]) {
        parent[lx] = ly;
      } else {
        parent[ly] = lx;
        rank[lx] += 1;
      }
      return false;
    } else {
      return true;
    }
  }

  public static int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    int tmp = find(parent[x]);
    parent[x] = tmp;
    return tmp;
  }
}
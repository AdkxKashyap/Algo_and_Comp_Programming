//Disjoint Set Union Concept
public class RedundantConnection {
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

  public int[] findRedundantConnection(int[][] edges) {
    int e = edges.length;
    int[] parent = new int[e + 1];
    int[] rank = new int[e + 1];
    for (int i = 0; i <= e; i++) {
      rank[i] = 1;
      parent[i] = i;
    }
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      int lx = find(parent, u);
      int ly = find(parent, v);
      if (lx == ly) {
        return edge;
      }
      union(parent, rank, lx, ly);
    }
    return new int[0];
  }
}

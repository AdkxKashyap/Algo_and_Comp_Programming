import java.util.*;

public class Test {
  static class Edge implements Comparable<Edge> {
    int v;
    int wt;

    Edge(int nbr, int wt) {
      this.v = nbr;
      this.wt = wt;
    }

    @Override
    public int compareTo(Edge o) {
      return this.wt - o.wt;
    }
  }
  public static int findMinCost(ArrayList<ArrayList<Edge>> graph) {
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    boolean vis[] = new boolean[graph.size()];
    int min = 0;
   
   pq.add(new Edge(0, 0));
    while(pq.size() > 0) {
      Edge rem = pq.poll();
      int v = rem.v;
      if(vis[v] == true) {
        continue;
      }
      vis[v] = true;
      int wt = rem.wt;
      min += wt;
      ArrayList<Edge> edges = graph.get(v);
      for(Edge e : edges) {
        if(vis[e.v] == false) pq.add(e);
      }
    }
    return min;
  }
}

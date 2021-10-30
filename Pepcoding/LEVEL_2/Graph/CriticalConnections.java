import java.util.*;
//lc-  1192
//SImilar to articulation point
class CriticalConnections {
  static int[] parent;
  static int[] reach;
  static int[] disc;
  static boolean[] vis;
  static List<List<Integer>> cp;
  static int time;
  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
      parent = new int[n];
      reach = new int[n];
      time = 0;
      disc = new int[n];
      vis = new boolean[n];
      cp = new ArrayList<>();
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for(int i = 0; i < n; i++) {
          graph.add(new ArrayList<>());
      }
      for(int i = 0; i < connections.size(); i++) {
          int frm = connections.get(i).get(0);
          int to = connections.get(i).get(1);
          graph.get(frm).add(to);
          graph.get(to).add(frm);
      }
      dfs(graph, 0);
      return cp;
      
  }
  public void dfs(ArrayList<ArrayList<Integer>> graph, int src) {
      vis[src] = true;
      reach[src] = disc[src] = time;
      time++;
      List<Integer> nbrs = graph.get(src);
      for(int nbr : nbrs) {
          if(parent[src] == nbr) continue;
          else if(vis[nbr] == true) {
              reach[src] = Math.min(reach[src], disc[nbr]);
          } else {
              parent[nbr] = src;
              dfs(graph, nbr);
              reach[src] = Math.min(reach[src], reach[nbr]);
              if(reach[nbr] > disc[src]) {
                  List<Integer> res= new ArrayList<>();
                  res.add(src);
                  res.add(nbr);
                  cp.add(res);
              }
          }
    }
  }
}
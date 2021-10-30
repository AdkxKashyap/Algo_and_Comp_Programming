package Graph;

import java.io.*;
import java.util.*;

public class isBipartite {
  static class Edge {
     int src;
     int nbr;
     int wt;

     Edge(int src, int nbr, int wt) {
        this.src = src;
        this.nbr = nbr;
        this.wt = wt;
     }
  }
  public static class Pair {
    int vtx;
    int level;

    public Pair(int vtx, int level){
      this.vtx = vtx;
      this.level = level;
    }
  }
  /**If cycle existe->
   *  if even length cycle return true
   * else return false
   * if no cyle is formed returned false
   */
  public static boolean isBipartiteComp(ArrayList<Edge>[] graph, int src, int[] vis){
    Queue<Pair> qu = new LinkedList<>();
    qu.add(new Pair(src, 0));
    int[] visited = new int[graph.length];
    Arrays.fill(visited, -1);

    while(qu.size() != 0){
      Pair rem = qu.remove();
      int vtx = rem.vtx;
      if(visited[vtx] == -1){
        /**not visited.visited[] stores at which level this element was found.If two elements are found at same lvl 
         * than cyclic graph has even length,continue,else return false.
        */
        visited[vtx] = rem.level;
        for(Edge e : graph[vtx]){
          //only add neighbours which are not visited
          if(visited[e.nbr] == -1)
            qu.add(new Pair(e.nbr, rem.level + 1));
        }
      }
      else {
        //visited
        if(visited[vtx] == rem.level)
          continue;
        else
          return false;
      }
      
    }
    return true;
  }

  public static boolean isBipartite(ArrayList<Edge>[] graph){
    int[] vis = new int[graph.length];
    Arrays.fill(vis, -1);
    //grapg can be disconnected so we are using outer loop to visist each componenet
    for(int i = 0; i < graph.length; i++){
      if(vis[i] == -1){
        boolean res = isBipartiteComp(graph, i, vis);
        if (res == false) return false;
      }
    }
    return true;
  }
  public static void main(String[] args) throws Exception {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

     int vtces = Integer.parseInt(br.readLine());
     ArrayList<Edge>[] graph = new ArrayList[vtces];
     for (int i = 0; i < vtces; i++) {
        graph[i] = new ArrayList<>();
     }

     int edges = Integer.parseInt(br.readLine());
     for (int i = 0; i < edges; i++) {
        String[] parts = br.readLine().split(" ");
        int v1 = Integer.parseInt(parts[0]);
        int v2 = Integer.parseInt(parts[1]);
        int wt = Integer.parseInt(parts[2]);
        graph[v1].add(new Edge(v1, v2, wt));
        graph[v2].add(new Edge(v2, v1, wt));
     }

     // write your code here
     boolean res = isBipartite(graph);
     System.out.println(res);
  }
}
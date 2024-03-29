package Main.Graph;
import java.io.*;
import java.util.*;

//is cyclic for undirected graph
public class isCyclic {
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
  public static boolean gcc(ArrayList<Edge>[] graph, int src, boolean[] vis){
    Queue<Integer> qu = new LinkedList<Integer>();
    
    qu.add(src);
    while(qu.size() > 0){
      int vtx = qu.remove();
      if(vis[vtx] == true) {
        //cycle detected
        return true;
      }
      vis[vtx] = true;
      for(Edge e : graph[vtx]) {
        if(vis[e.nbr] == false)
          qu.add(e.nbr);
      }
    }
    return false;
  }
  public static boolean isCyclic(ArrayList<Edge>[] graph) {
    boolean[] vis = new boolean[graph.length];
    for(int i = 0; i < graph.length; i++) {
      if(vis[i] == false) {
        boolean res = gcc(graph, i, vis);
        if(res == true) return true;
      }
    }
    return false;
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
     boolean res = isCyclic(graph);
     System.out.println(res);
  }
}
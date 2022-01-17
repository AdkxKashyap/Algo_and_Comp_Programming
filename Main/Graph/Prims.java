package Main.Graph;

import java.io.*;
import java.util.*;

//minimum spanning tree
public class Prims {
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

  public static class Pair implements Comparable<Pair> {
    int wt;
    int parent;
    int src;

    public Pair(int src, int from, int wt) {
      this.wt = wt;
      this.src = src;
      this.parent = from;
    }

   @Override
   public int compareTo(Pair o) {
     // TODO Auto-generated method stub
     return this.wt - o.wt;
   }
  } 

  public static ArrayList<Edge>[] getMST(ArrayList<Edge>[] graph) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    boolean[] vis = new boolean[graph.length];
    ArrayList<Edge>[] mst = new ArrayList[graph.length];
    for(int i = 0; i < graph.length; i++){
      mst[i] = new ArrayList<>();
    }
    pq.add(new Pair(0, -1 , 0));

    while(pq.size() > 0) {
      Pair rem = pq.remove();
      int vtx = rem.src;
      int parent = rem.parent;
      //first element
      if(parent == -1) {
        vis[vtx] = true;
        for(Edge e : graph[vtx]){
          pq.add(new Pair(e.nbr, vtx, e.wt));
        }
        continue;
      }

      if(vis[vtx] == true) continue;
      vis[vtx] = true;
      mst[parent].add(new Edge(parent, vtx, rem.wt));
      System.out.println("[" + vtx + "-" + parent + "@" + rem.wt + "]");
      for(Edge e : graph[vtx]){
        if(vis[e.nbr] == false) {
          pq.add(new Pair(e.nbr, vtx, e.wt));
        }
      }
    }
    return mst;
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
     ArrayList<Edge>[] mst = getMST(graph);
    //  for(int i = 0; i < mst.length; i++) {
    //    for(Edge e : mst[i]){
         
    //    }
     }
  }

}

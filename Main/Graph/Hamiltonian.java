package Main.Graph;

import java.io.*;
import java.util.*;

public class Hamiltonian {
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

   public static void hamiltonian(ArrayList<Edge>[] graph, int src, int orignSrc, HashSet<Integer> vis, String psf){
    //if all nodes are visited
    if(vis.size() == graph.length - 1){
      System.out.print(psf + src);

      boolean isCyclic = false;
      //check if cyclic or only path
      for(Edge e : graph[src]){
        if(e.nbr == orignSrc){
          isCyclic = true;
        }
      }
      if(isCyclic == true){
        System.out.println("*");
      }
      else
        System.out.println(".");

        return;
    }
    vis.add(src);
    for(Edge e : graph[src]){
      if(vis.contains(e.nbr) == false){
        hamiltonian(graph, e.nbr, orignSrc, vis, psf + src);
      }
    }
    vis.remove(src);
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

      int src = Integer.parseInt(br.readLine());

      // write all your codes here
      HashSet<Integer> vis = new HashSet<>();
      hamiltonian(graph, src, src, vis, "");
   }


}

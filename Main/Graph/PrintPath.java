package Main.Graph;



import java.io.*;
import java.util.*;

public class PrintPath {
   static class Edge {
      int src;
      int nbr;
      int wt;
      
      Edge(int src, int nbr, int wt){
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   public static void printPath(ArrayList<Edge>[] graph, int src, int dest, String psf, boolean[] visited){
       if(src == dest) {
         psf += src;
         System.out.println(psf);
         return;
       };
       
       visited[src] = true;
       for(Edge e : graph[src]){
           int neighbour = e.nbr;
           if(visited[neighbour] == false){
               printPath(graph, neighbour, dest, psf + src, visited);
           }
       }
       visited[src] = false;
   }
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for(int i = 0; i < vtces; i++){
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for(int i = 0; i < edges; i++){
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      // write your code here
      boolean[] visited = new boolean[graph.length];
      System.out.println(hasPath(graph, src, dest, visited));
    }

}


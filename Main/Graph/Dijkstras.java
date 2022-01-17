package Main.Graph;


import java.io.*;
import java.util.*;

public class Dijkstras {
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
     int wsf;
     String psf;
     int src;

     public Pair(int src, String psf, int wsf) {
       this.wsf = wsf;
       this.src = src;
       this.psf = psf;
     }

    @Override
    public int compareTo(Pair o) {
      // TODO Auto-generated method stub
      return this.wsf - o.wsf;
    }
   }

   public static void getMinimumWeight(ArrayList<Edge>[] graph, int src) {
     PriorityQueue<Pair> pq = new PriorityQueue<>();
     boolean[] vis = new boolean[graph.length];
     pq.add(new Pair(src, src + "", 0));

     while(pq.size() > 0) {
       Pair rem = pq.remove();
       int vtx = rem.src;
       if(vis[vtx] == true) continue;
       vis[vtx] = true;
       System.out.println(src + "via" + rem.psf + "@" + rem.wsf);

       for(Edge e : graph[vtx]){
         if(vis[e.nbr] == false) {
           pq.add(new Pair(src, rem.psf + e.nbr, rem.wsf + e.wt));
         }
       }
     }
   }
   //Shortest Path In Weights
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
      // write your code here
      getMinimumWeight(graph, src);
      
   }
}

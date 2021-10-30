package Graph;

//shortest path edge-wise.Weights not considered
import java.io.*;
import java.util.*;

public class BFS {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static class BFSN {
     int vtx;
     String psf;

     public  BFSN(int vtx, String psf){
       this.vtx = vtx;
       this.psf = psf;
     }
   }

   public static void bfs(ArrayList<Edge>[] graph, int src){
     Queue<BFSN> qu = new  LinkedList<>();
     qu.add(new BFSN(src, "0"));
      boolean[] vis = new boolean[graph.length];
     while(qu.size() > 0){
       BFSN nn = qu.remove();
       String psf = nn.psf;
       if(vis[nn.vtx] == true) continue;
       else {
         vis[nn.vtx] = true;
       }
       System.out.println(nn.vtx + "@" + psf);
       for(Edge e : graph[nn.vtx]){
         qu.add(new BFSN(e.nbr, psf + e.nbr));
       }
     }
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // write your code here  
      bfs(graph, src);
   }
}

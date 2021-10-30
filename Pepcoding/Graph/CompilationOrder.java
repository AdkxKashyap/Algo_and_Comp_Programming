package Graph;

import java.io.*;
import java.util.*;

//Topological sort
public class CompilationOrder {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   public static void tsHelper(ArrayList<Edge>[] graph, int src, boolean[] vis, Stack<Integer> stk) {
    vis[src] = true;
    
    for(Edge e : graph[src]) {
      int nbr = e.nbr;
      if(vis[nbr] == false) {
        tsHelper(graph, nbr, vis, stk);
      }
    }
    stk.push(src);
   }

   public static void ts(ArrayList<Edge>[] graph) {
    Stack<Integer> stk = new Stack<>();
    boolean[] vis = new boolean[graph.length];
    for( int i = 0; i < graph.length; i++) {
      if(vis[i] == false) {
        tsHelper(graph, i, vis, stk);
      }
    }

    //print stack
    while(stk.size() > 0) {
      System.out.println(stk.pop());
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
      }

      // write your code here
   }

}

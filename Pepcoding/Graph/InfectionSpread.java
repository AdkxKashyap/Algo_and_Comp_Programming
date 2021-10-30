package Graph;

import java.io.*;
import java.util.*;

public class InfectionSpread {
  static class Edge {
     int src;
     int nbr;

     Edge(int src, int nbr) {
        this.src = src;
        this.nbr = nbr;
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

  public static int infectionSpread(ArrayList<Edge>[] graph, int src, int t) {
    Queue<Pair> qu = new LinkedList<>();
    int[] visited = new int[graph.length];
    qu.add(new Pair(src, 1));
    int count = 0;
    while(qu.size() != 0){
      Pair rem = qu.remove();
      int vtx = rem.vtx;
      int lvl = rem.level;
      if(visited[vtx] != 0) continue;
      
      if(lvl > t) return count;
      visited[vtx] = lvl;
      count++;
      for(Edge e : graph[vtx]) {
        qu.add(new Pair(e.nbr, lvl + 1));
      }
    }
    return count;
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
     int t = Integer.parseInt(br.readLine());
     
     // write your code here
     int res = infectionSpread(graph, src, t);
     System.out.println(res);
  }

}

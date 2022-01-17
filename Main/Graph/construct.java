package Main.Graph;

import java.util.*;

public class construct {
  public static class Edge{
    int v1;
    int v2;
    int wt;

    public Edge(int v1, int v2, int wt){
      this.v1 = v1;
      this.v2 = v2;
      this.wt = wt;
    }

    public static void addEdge(ArrayList<Edge>[] graph, int v1, int v2, int wt){
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    public static void fun(){
      int n = 7;//number of vertices
      ArrayList<Edge>[] graph = new ArrayList[n];
      for(int i = 0; i < graph.length; i++){
        graph[i] = new ArrayList<>();
      }
      int[][] data = {
        {0 ,1, 10},
        {0, 3, 40},
        {1, 2, 10},
        {2, 3, 10},
        {3, 4, 2},
        {4, 5, 3},
        {4, 6, 8},
        {5, 6, 3}
      };

      for(int[] entry : data){
        addEdge(graph, entry[0], entry[1], entry[2]);
      }
      display(graph);
    }

    public static void display(ArrayList<Edge>[] graph){
      int i = 0;
      for(ArrayList<Edge> list: graph){
        System.out.print("[" + i + "]->");
        for(Edge edge : list){
          System.out.print(edge.v1 + "<->" + edge.v2 + " @ " + edge.wt + ",");
        }
        System.out.println();
        i++;
      }
    }
    public static void main(String[] args) {
      fun();
    }
  }


}

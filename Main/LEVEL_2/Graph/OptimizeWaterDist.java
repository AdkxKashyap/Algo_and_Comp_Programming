package Main.LEVEL_2.Graph;
import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int v = Integer.parseInt(st[0]);
    int e = Integer.parseInt(st[1]);

    int[] wells = new int[v];
    String[] words = br.readLine().split(" ");

    for (int i = 0; i < wells.length; i++) {
      wells[i] = Integer.parseInt(words[i]);
    }

    int[][] pipes = new int[e][3];
    for (int i = 0; i < e; i++) {
      String[] st1 = br.readLine().split(" ");
      pipes[i][0] = Integer.parseInt(st1[0]);
      pipes[i][1] = Integer.parseInt(st1[1]);
      pipes[i][2] = Integer.parseInt(st1[2]);
    }

    System.out.println(minCostToSupplyWater(v, wells, pipes));

  }
  public static class Pair implements Comparable<Pair> {
    int vtx = 0;
    int wt = 0;
    Pair(int vtx, int wt) {
      this.vtx = vtx;
      this.wt = wt;
    }
    @Override
    public int compareTo(Pair o) {
      // TODO Auto-generated method stub
      return this.wt-o.wt;
    }
  }
  public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
    //create the graph
    ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
    for(int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    for(int i = 0; i < pipes.length; i++) {
      int u = pipes[i][0];
      int v = pipes[i][1];
      int wt = pipes[i][2];
      graph.get(u).add(new Pair(v, wt));
      graph.get(v).add(new Pair(u, wt));
    }
    //add edges from 0
    for(int i = 1; i <= n; i++) {
      graph.get(0).add(new Pair(i, wells[i-1]));
    }
    //Run Prims
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(0, 0));//start from 0
    boolean[] vis = new boolean[n+1];
    int ans = 0;
    while(pq.size() > 0) {
      Pair rem = pq.poll();
      int vtx = rem.vtx;
      int wt = rem.wt;
      if(vis[vtx] == true) continue;
      vis[vtx] = true;
      ans+=wt;
      for(Pair nbr : graph.get(vtx)) {
        if(vis[nbr.vtx] == true) continue;
        pq.add(new Pair(nbr.vtx, nbr.wt));
      }
    }
    return ans;
  }
}

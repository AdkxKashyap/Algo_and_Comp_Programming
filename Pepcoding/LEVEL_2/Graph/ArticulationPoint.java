import java.util.*;
import java.io.*;

class ArticulationPoint {
  static int[] parent;
  static int[] disc;
  static int[] low;
  static boolean[] vis;
  static boolean[] ap;
  static int time;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int vtces = sc.nextInt();
    int edges = sc.nextInt();
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for(int i = 0; i < vtces; i++) {
      graph.add(new ArrayList<>()) ;
    }
    for(int i = 0; i < edges; i++) {
      int frm = sc.nextInt()-1;
      int to = sc.nextInt()-1;
      graph.get(frm).add(to);
      graph.get(to).add(frm);
    }
    disc = new int[vtces];
    parent = new int[vtces];
    low = new int[vtces];
    ap = new boolean[vtces];
    vis = new boolean[vtces];
    time = 0;
    //start from 0.
    parent[0] = -1;
    dfs(graph, 0);
    int ans = 0;
    for(int i = 0; i < vtces; i++) {
      if(ap[i] == true) ans++;
    }
    System.out.println(ans);
  }
  public static void dfs(ArrayList<ArrayList<Integer>> graph, int src) {
    low[src] = disc[src] = time;
    time++;
    vis[src] = true;
    int count = 0;
    ArrayList<Integer> nbrs = graph.get(src);
    for(int nbr : nbrs) {
      /**cannnot use the path we are coming frm */
      if(parent[src] == nbr) continue;
      else if(vis[nbr] == true){
        //**Why compare low and disc here*/
        low[src] = Math.min(low[src], disc[nbr]);
      } else {
        parent[nbr] = src;
        count++;
        dfs(graph, nbr);
        //**Why compare low and low here*/
        low[src] = Math.min(low[src], low[nbr]);
        //** **IMP */
        if(parent[src] == -1) {
          //for root node we need this cond to check if root is ap.
          if(count >= 2) {
            ap[src]  = true;
          }
        }
        if(low[nbr] >= disc[src]) {
          ap[src] = true;
        }
      }
    }
  }
}
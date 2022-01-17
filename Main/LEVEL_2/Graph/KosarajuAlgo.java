package Main.LEVEL_2.Graph;

//Strongly connected components 
import java.util.*;

public class KosarajuAlgo {
  public static int count;

  public static void randomDFS(ArrayList<ArrayList<Integer>> adj, int src, Stack<Integer> stk, boolean[] vis) {
    vis[src] = true;
    for (int nbr : adj.get(src)) {
      if (vis[nbr] == false) {
        randomDFS(adj, nbr, stk, vis);
      }
    }
    stk.push(src);
  }

  public static void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis) {
    vis[src] = true;
    for (int nbr : adj.get(src)) {
      if (vis[nbr] == false) {
        dfs(adj, nbr, vis);
      }
    }
  }

  public static void kosaraju(ArrayList<ArrayList<Integer>> adj, int vtces) {
    Stack<Integer> stk = new Stack<>();
    boolean[] vis = new boolean[vtces];

    // Run Random DFS and add elem to queue
    for (int v = 0; v < vtces; v++) {
      if (vis[v] == false) {
        /** Top of queue will give node from which all node can be visited */
        randomDFS(adj, v, stk, vis);
      }
    }
    // Create a Graph with Edges reversed
    ArrayList<ArrayList<Integer>> rGraph = new ArrayList<>();
    for (int i = 0; i < vtces; i++) {
      rGraph.add(new ArrayList<>());
    }
    for (int i = 0; i < vtces; i++) {
      ArrayList<Integer> nbrs = adj.get(i);
      for (int nbr : nbrs) {
        rGraph.get(nbr).add(i);
      }
    }
    // Run DFS on rGraph usinh stk
    count = 0;
    vis = new boolean[vtces];
    while (stk.size() > 0) {
      int rem = stk.pop();
      if (vis[rem] == false) {
        count++;
        dfs(rGraph, rem, vis);
      }
    }
  }

  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int v = sc.nextInt();
    int e = sc.nextInt();
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < v; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 0; i < e; i++) {
      int frm = sc.nextInt()-1;
      int to = sc.nextInt()-1;
      adj.get(frm).add(to);
    }
    kosaraju(adj, v);
    System.out.println(count);
  }
}

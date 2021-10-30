import java.io.*;
import java.util.*;


public class MotherVertex{
    	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			int u = Integer.parseInt(st[0]) - 1;
			int v = Integer.parseInt(st[1]) - 1;
			graph.get(u).add(v);
		}

		System.out.println(findMotherVertex(n, graph));
	}
    static int  count;
    public static void dfsForStack(ArrayList<ArrayList<Integer>>adj,int src, Stack<Integer> stk, boolean[] vis) {
      vis[src] = true;
      for(int nbr : adj.get(src)) {
        if(vis[nbr] == false) {
          dfsForStack(adj, nbr, stk, vis);
        }
      }
      stk.push(src);
    }
    public static void dfsForCount(ArrayList<ArrayList<Integer>>adj,int src, boolean[] vis) {
      vis[src] = true;
      count++;
      for(int nbr : adj.get(src)) {
        if(vis[nbr] == false) {
          dfsForCount(adj, nbr, vis);
        }
      }
    }
    public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>>adj){
			boolean[] vis = new boolean[N];
      Stack<Integer> stk = new Stack<>();
      for(int v = 0; v < N; v++) {
        if(vis[v] == false) {
          dfsForStack(adj, v, stk, vis);
        }
      }
      int top = stk.pop();//candidate for mother vertex
      count = 0;
      vis = new boolean[N];
      dfsForCount(adj, top, vis);
      return count == N ? top+1 : -1;
    }
}
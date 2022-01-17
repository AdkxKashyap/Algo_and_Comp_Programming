package Main.LEVEL_2.Graph;
import java.io.*;
import java.util.*;

public class Main {

  public static class Pair {
    int v;
    int wt;
    Pair(int v, int wt) {
      this.v = v;
      this.wt = wt;
    }
  }
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);
    
    ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
    for(int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for(int i = 0; i < m; i++) {
      st = br.readLine().split(" ");
      int u = Integer.parseInt(st[0])-1;//0-based
      int v = Integer.parseInt(st[1])-1;
      //add original edge
      graph.get(u).add(new Pair(v, 0));
      //reverse edge.
      graph.get(v).add(new Pair(u, 1));
    }
    LinkedList<Pair> que = new LinkedList<>();
    boolean[] vis = new boolean[n];
    que.add(new Pair(0, 0));
    while(que.size() > 0) {
      Pair rem = que.poll();
      int vtx = rem.v;
      int wt = rem.wt;
      vis[vtx] = true;
      if(vtx == n-1) {
        System.out.println(wt);
        return;
      }
      for(Pair nbr : graph.get(vtx)) {
        int nvtx = nbr.v;
        if(vis[nvtx] == true) continue;
        int nwt = nbr.wt;
        if(nwt == 0) {
          //add to same zone
          que.addFirst(new Pair(nvtx, wt+0));
        }else {
          que.addLast(new Pair(nvtx, wt+1));
        }
      }
    }
    System.out.println(-1);//edge case where n is not present
	}
}

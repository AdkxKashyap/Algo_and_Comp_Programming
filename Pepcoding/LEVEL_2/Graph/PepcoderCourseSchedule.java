import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);
    int[][] prerequisites = new int[m][2];
    for (int i = 0; i < m; i++) {
      st = br.readLine().split(" ");
      prerequisites[i][0] = Integer.parseInt(st[0]);
      prerequisites[i][1] = Integer.parseInt(st[1]);
    }
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for(int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for(int i = 0; i < m; i++) {
      int u = prerequisites[i][0];
      int v = prerequisites[i][1];
      graph.get(v).add(u);
    }
    int[] arr = prepSchedule(graph, n, m);
    for(int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
  public static int[] prepSchedule(ArrayList<ArrayList<Integer>> graph, int n, int m) {
    //prep indegree array
    int[] indeg = new int[n];
    for(int i = 0; i < n; i++) {
      for(int nbr : graph.get(i)) {
        indeg[nbr]++;
      }
    }
    LinkedList<Integer> que = new LinkedList<>();
    //add all nodes with indeg = 0 to queue
    for(int i = 0; i < n; i++) {
      if(indeg[i] == 0) que.addLast(i);
    }
    //process queue
    int[] ans = new int[n];
    int cn = 0;
    while(que.size() > 0) {
      int edge = que.removeFirst();
      //add elem in order in which they were processed
      ans[cn] = edge;
      cn++;
      for(int nbr : graph.get(edge)) {
        indeg[nbr]--;
        //no more dependencies so it can be processed
        if(indeg[nbr] == 0) {
          que.addLast(nbr);
        }
      }
    }
    //if there is a circle all nodes wont be covered ret -1 
    return cn == n ? ans : new int[]{-1};
  }
}

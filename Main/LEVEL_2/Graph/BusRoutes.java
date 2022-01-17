package Main.LEVEL_2.Graph;
import java.io.*;
import java.util.*;

class BusRoutes {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    String[] st1 = br.readLine().split(" ");
    int src = Integer.parseInt(st1[0]);
    int dest = Integer.parseInt(st1[1]);
    System.out.println(numBusesToDestination(arr, src, dest));

  }

  public static int numBusesToDestination(int[][] routes, int S, int T) {
    HashMap<Integer,ArrayList<Integer>> hmap = new HashMap<>();
    for(int i = 0; i < routes.length; i++) {
      for(int j = 0; j < routes[0].length; j++) {
        int busstop = routes[i][j];
        ArrayList<Integer> buses = hmap.getOrDefault(busstop, new ArrayList<Integer>());
        buses.add(i);
        hmap.put(busstop, buses);
      }
    }
    HashSet<Integer> busStopVis = new HashSet<>();
    HashSet<Integer> busVis = new HashSet<>();
    Queue<Integer> que = new LinkedList<Integer>();
    int level = 0;
    que.add(S);
    while(que.size() > 0) {
      int size = que.size();
      while(size-- > 0) {
        int remStp = que.poll();
        if(remStp == T) return level;
        ArrayList<Integer> buses = hmap.get(remStp);
        for(int bus : buses) {
          if(!busVis.contains(bus)) {
            int[] bstops = routes[bus];
            for(int stop : bstops) {
              if(!busStopVis.contains(stop)) {
                  que.add(stop);
                  busStopVis.add(stop);
              }
            }
            busVis.add(bus);
          }
        }
      }
      level++;
    }
    return -1;
  }
}

package Main.LEVEL_2.Stacks;
import java.util.PriorityQueue;

public class TrappingRainwater2 {
  public static class Pair implements Comparable<Pair> {
    int row;
    int col;
    int val;
    Pair(int row, int col, int val) {
      this.row = row;
      this.col = col;
      this.val = val;
    }
    @Override
    public int compareTo(Pair o) {
      // TODO Auto-generated method stub
      return this.val - o.val;
    }
  }
  public int trapRainWater(int[][] heightMap) {
    int n = heightMap.length;
    int m = heightMap[0].length;
        //Create pq
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[][] vis = new boolean[n][m];
        //top row
        for(int col = 0; col <  m; col++) {
          pq.add(new Pair(0, col,heightMap[0][col]));
          vis[0][col] = true;
        }
        //right most col
        for(int row = 0; row < n; row++) {
          if(vis[row][m-1] == false) {
            vis[row][m-1] = true;
            pq.add(new Pair(row, n-1, heightMap[row][m-1]));
          }
        }
        //bottom row
        for(int col = m-1; col >= 0; col--) {
          if(vis[n-1][col] == false) {
            vis[n-1][col] = true;
            pq.add(new Pair(n-1, col, heightMap[n-1][col]));
          }
        }
        //left most col
        for(int i = n-1; i >= 0; i--) {
          if(vis[i][0] == false) {
            vis[i][0] = true;
            pq.add(new Pair(i, 0, heightMap[i][0]));
          }
        }
        int water = 0;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(pq.size() > 0) {
          Pair rem = pq.poll();
          int c = rem.col;
          int r = rem.row;
          for(int[] dir : dirs) {
            int rowd = r + dir[0];
            int cold = c + dir[1];
            if(rowd >= 0 && cold >= 0 && rowd < n && cold < m && vis[rowd][cold] == false) {
              vis[rowd][cold] = true;
              water += Math.max(0, rem.val - heightMap[rowd][cold]);

              //add to PQ
              if(heightMap[rowd][cold] >= heightMap[r][c]) {
                pq.add(new Pair(rowd, cold, heightMap[rowd][cold]));
              } else {
                pq.add(new Pair(rowd, cold, heightMap[r][c]));
              }
            }
          }
        }
        return water;
  }
}

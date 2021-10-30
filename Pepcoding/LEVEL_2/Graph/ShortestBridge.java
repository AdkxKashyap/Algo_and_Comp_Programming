
//lc - 934
import java.util.*;

class Solution {
  static int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

  public class Pair {
    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  public void dfsShortestBridge(int[][] grid, int r, int c, Queue<Pair> que) {
    que.add(new Pair(r, c));
    grid[r][c] = -1;
    for (int d = 0; d < 4; d++) {
      int row = dir[d][0] + r;
      int col = dir[d][1] + c;
      if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
          dfsShortestBridge(grid, row, col, que);
      }
    }
  }
  public int shortestBridge(int[][] grid) {
    Queue<Pair> que = new LinkedList<>();
    loop1: for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          // run dfs
          dfsShortestBridge(grid, i, j, que);
          break loop1;
        }
      }
    }
    // level = 0 if we had to count edge.here count vtices
    int level = -1;
    while (que.size() > 0) {
      int size = que.size();
      level++;
      while (size-- > 0) {
        Pair rem = que.remove();
        int r = rem.x;
        int c = rem.y;
        for (int d = 0; d < 4; d++) {
          int row = dir[d][0] + r;
          int col = dir[d][1] + c;
          if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != -1) {
            if (grid[row][col] == 1)
              return level;
            que.add(new Pair(row, col));
            grid[row][col] = -1;
          }
        }
      }
    }
    return level;
  }
}
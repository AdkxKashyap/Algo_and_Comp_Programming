import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AsFarFromLandAsPossible {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(maxDistance(arr));

  }

  static int[][] dir = {{-1,0}, {0, -1}, {1,0}, {0,1}};
  static class Pair {
    int x = 0;
    int y = 0;
    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    } 
  }
  public static int maxDistance(int[][] grid) {
    Queue<Pair> que = new LinkedList<>();
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] == 1) {
          que.add(new Pair(i, j));
          //mark visisted
          grid[i][j] = -1;
        }
      }
    }
    if(que.size() == 0 || que.size() == grid.length * grid[0].length) return -1;
    int level = -1;//this is the max distance
    while(que.size() > 0) {
      int size = que.size();
      while(size-- > 0) {
        Pair rem = que.poll();
        int r = rem.x;
        int c = rem.y;
        for(int d = 0; d < 4; d++) {
          int row = dir[d][0] + r;
          int col = dir[d][1]+ c;
          if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != -1){
            que.add(new Pair(row, col));
            grid[row][col] = -1;
            }
          }
      }
      level++;
    }
    return level;
  }
}

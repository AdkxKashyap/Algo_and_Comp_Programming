import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
  private static class Pair {
    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    int[][] ans = updateMatrix(arr);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(ans[i][j] + " ");
      }
      System.out.println();
    }

  }
  static int[][] dir = {{-1,0}, {0, -1}, {1,0}, {0,1}};
  public static int[][] updateMatrix(int[][] matrix) {
    Queue<Pair> que = new LinkedList<>();
    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[0].length; j++) {
        if(matrix[i][j] == 1) matrix[i][j] = -1;
        else que.add(new Pair(i, j));
      }
    }
    while(que.size() > 0) {
      int size = que.size();
      while(size-- > 0) {
        Pair rem = que.poll();
        int r = rem.x;
        int c = rem.y;
        for(int d = 0; d < 4; d++) {
          int row = dir[d][0] + r;
          int col = dir[d][1]+ c;
          if(row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col] < 0){
            que.add(new Pair(row, col));
            matrix[row][col] = matrix[r][c] + 1;
          }
        }
      } 
    }
    return matrix;
  }
}
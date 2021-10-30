import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

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

    System.out.println(numDistinctIslands(arr));

  }
  static int[][] dir = {{-1,0}, {0, -1}, {1,0}, {0,1}};
  static char[] s_dir= {'t', 'l', 'd', 'r'}; 
  public static void dfs(int[][] arr,int r, int c, StringBuilder psf) {
    arr[r][c] = 0;
    for(int d = 0; d < 4; d++) {
      int row = dir[d][0] + r;
      int col = dir[d][1]+ c;
      if(row >= 0 && row < arr.length && col >= 0 && col < arr[0].length && arr[row][col] == 1){
        psf.append(s_dir[d]);
        dfs(arr, row, col, psf);
      }
      psf.append("z");
    }
  }
  public static StringBuilder psf ;
  public static int numDistinctIslands(int[][] arr) {
    //write your code here
    HashSet<String> hs = new HashSet<>();
    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr[0].length; j++) {
        if(arr[i][j] == 1) {
          psf = new StringBuilder();
          dfs(arr, i, j, psf);
          hs.add(psf.toString());
        }
      }
    }
    return hs.size();
  }
}
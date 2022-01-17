package Main.LEVEL_2.Graph;
class NumberOfEnclave {
  static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  public void dfs(int[][] grid, int r, int c) {
      grid[r][c] = 0;
      for(int d = 0; d < 4; d++) {
          int row = dir[d][0] + r;
          int col = dir[d][1] + c;
          if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1){
              dfs(grid, row, col);
          }
      }
  }
  public int numEnclaves(int[][] grid) {
      //1st row
      for(int j = 0; j < grid[0].length; j++) {
          if(grid[0][j] == 1) {
              dfs(grid, 0, j);
          }
      }
      //last row
      for(int j = 0; j < grid[0].length; j++) {
          if(grid[grid.length-1][j] == 1) {
              dfs(grid, grid.length-1, j);
          }
      }
      
      //1st col
      for(int i = 0; i < grid.length; i++) {
          if(grid[i][0] == 1) {
              dfs(grid, i, 0);
          }
      }
      //last col
       for(int i = 0; i < grid.length; i++) {
          if(grid[i][grid[0].length-1] == 1) {
              dfs(grid, i, grid[0].length-1);
          }
      }
      int count = 0;
      for(int i = 0; i < grid.length; i++) {
          for(int j = 0; j < grid[0].length; j++) {
              if(grid[i][j] == 1) count++;
          }
      }
      return count;
  }
}
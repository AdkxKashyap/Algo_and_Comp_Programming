class Goldmine2 {
  public final int dir[][] = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
  public int dfs(int row, int col, int[][] grid) {
      int max = 0;
      for(int d = 0; d < 4; d++) {
          int rowdash = row + dir[d][0];
          int coldash = col + dir[d][1];
          if(rowdash >= 0 && rowdash < grid.length && coldash >= 0 && coldash < grid[0].length && grid[rowdash][coldash] > 0) {
              int val = grid[rowdash][coldash];
              grid[rowdash][coldash] = -val;
              max = Math.max(max, dfs(rowdash, coldash, grid));
              grid[rowdash][coldash] = val;
          } 
      }
      return max + Math.abs(grid[row][col]);
  }
  public int getMaximumGold(int[][] grid) {
      int max = 0;
      for(int i = 0; i < grid.length; i++) {
          for(int j = 0; j < grid[0].length; j++) {
              if(grid[i][j] > 0) {
                  int val = grid[i][j];
                  //mark
                  grid[i][j] = -val;
                  max = Math.max(dfs(i, j, grid), max);
                      //unmark
                  grid[i][j] = val;
              }
          }
         
      }
       return max;
  }
}
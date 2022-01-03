//lc 1034
class ColorBorder {
  public int[][] colorBorder(int[][] grid, int row, int col, int color) {
    dfs(grid, row, col, grid[row][col]);
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] < 0) {
          grid[i][j] = color;
        }
      }
    }
    return grid;
  }

  public static void dfs(int[][] grid, int row, int col, int val) {
    // mark as part of border
    grid[row][col] = -val;
    int count = 0;
    int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    for (int d = 0; d < 4; d++) {
      int row_ = dir[d][0] + row;
      int col_ = dir[d][1] + col;
      if (row_ < 0 || row_ >= grid.length || col_ < 0 || col_ >= grid[0].length || Math.abs(grid[row_][col_]) != val)
        continue;

      count++;
      if (grid[row_][col_] == val) {
        dfs(grid, row_, col_, val);
      }
    }
    // if 4 dir surrounded by val, than not a part of border.Unmark
    if (count == 4)
      grid[row][col] = val;
  }
}
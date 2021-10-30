class RottenOranges {
  public  class OPair {
  int x;
  int y;
  int time;
  public OPair(int x, int y, int t) {
    this.x = x;
    this.y = y;
    this.time = t;
  }
}
static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
public  int orangesRotting(int[][] grid) {
  int oranges = 0;
  Queue<OPair> que = new LinkedList<OPair>();
  for(int i = 0; i < grid.length; i++) {
    for(int j = 0; j < grid[0].length; j++) {
      if(grid[i][j] == 2) {
        que.add(new OPair(i, j, 0));
        oranges++;
      }
      else if(grid[i][j] == 1) oranges++;
    }
  }
  int time = 0;
  while(que.size() > 0) {
    int size = que.size();
    while(size-- > 0) {
      OPair p = que.poll();
      int r = p.x;
      int c = p.y;
      //mark visited
      if(grid[r][c] == -1) continue;
      grid[r][c] = -1;
      time = p.time;
      oranges--;
      for(int d = 0; d < 4; d++) {
        int row = dir[d][0] + r;
        int col = dir[d][1] + c;
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
          que.add(new OPair(row, col, time+1));
        }
      }
    }
  }
  return oranges == 0 ? time : -1;
}
}
package Main.Graph;

import java.util.*;

//lc 994
public class RottenOranges {
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

  public  int orangesRotting(int[][] grid) {
    /**Creating a queue and adding initial rotten oranges.We will use level order traversal.Also keep count of all oranges.*/
    Queue<OPair> qu = new LinkedList<>();
    int oranges = 0;
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] == 2) {
          //init time is 0;
          qu.add(new OPair(i, j, 0));
          oranges++;
        }
        if(grid[i][j] == 1) oranges++;
      }
    }
    if (oranges == 0) return 0; 
    int time = -1;
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    while(qu.size() > 0) {
      int size = qu.size();
      while(size-- > 0) {
        OPair p = qu.poll();
        if(grid[p.x][p.y] == -1) continue;
          
        //marking visited with -1.Cannot mark with 2 bcoz initial case will fail 
        grid[p.x][p.y] = -1;
         time = p.time;
          
        oranges--;
        //traverse in 4 direction
        for(int d = 0; d < 4; d++) {
          int row = p.x + dir[d][0];
          int col = p.y + dir[d][1];
          if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
            qu.add(new OPair(row, col, p.time + 1));
          }
        }
      }
      //dont do it here
     //time++
    }
    //if all oranges gets rotten only than return time
    return oranges == 0 ? time : -1;
  }
}

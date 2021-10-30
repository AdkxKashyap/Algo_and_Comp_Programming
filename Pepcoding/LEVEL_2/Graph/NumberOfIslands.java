import java.util.*;
import java.io.*;
public class NumberOfIslands {
  // This is based on union find concept
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);
    int q = Integer.parseInt(st[2]);

    int[][] pos = new int[q][2];
    for (int i = 0; i < q; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    System.out.println(numIslands2(m, n, pos));
  }

  public static List<Integer> numIslands2(int m, int n, int[][] positions) {
    int[] parent = new int[m*n];
    int[] rank = new int[m*n];
    int count = 0;
    Arrays.fill(parent, -1);
    //we need ans for every operation, i.e after we have processed one position
    List<Integer> res = new ArrayList<>();
    for(int i = 0; i < positions.length; i++) {
      int r = positions[i][0];
      int c = positions[i][1];
      //this is the cell value
      int cell = r*n+c;
      if(parent[cell] != -1) {
        //cell already visited
        res.add(count);
        continue;
      }
      count++;
      parent[cell] = cell;
      rank[cell] = 1;
      int[][] dir = {{-1, 0}, {0, 1}, {1,0}, {0, -1}};
      for(int d = 0; d < 4; d++) {
        int row = r + dir[d][0];
        int col = c + dir[d][1];
        int cell_ = row*n+col;
        if(row >= 0 && row < m && col >= 0 && col < n && parent[cell_] != -1) {
          int lx = find(cell, parent);
          int ly = find(cell_, parent);
          if(lx != ly) {
            if(rank[lx] > rank[ly]) {
              parent[ly] = lx;
            }else if(rank[ly] > rank[lx]) {
              parent[lx] = ly;
            } else {
              parent[ly] = lx;
              rank[lx] ++;
            }
            count--;
          }
        }
      }
      res.add(count);
    }
    return res;
  }
  public static int find(int cellVal, int[] par) {
    if(par[cellVal] == cellVal) return cellVal;
    int tmp = find(par[cellVal], par);
    par[cellVal] = tmp;
    return tmp;
  }
}

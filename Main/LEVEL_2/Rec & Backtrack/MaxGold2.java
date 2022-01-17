import java.util.*;

public class MaxGold2 {
  static int max = 0;
  static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
  public static int dfs(int[][] mine, int r, int c) {
    
    int gold = mine[r][c];
    mine[r][c] = -1;
    //explore tldr
    for(int d = 0; d < dir.length; d++) {
      int nr = r + dir[d][0];
      int nc = c + dir[d][1];
      if(nr >= 0 && nc >=0 && nr < mine.length && nc < mine[0].length && mine[nr][nc] > 0) {
        gold += dfs(mine, nr, nc);
      }
    }
    return gold;
  }
  //similar to count island problem.
  public static void getMaxGold(int[][] arr) {
    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr[0].length; j++) {
        if(arr[i][j] > 0) {
           max = Math.max(max, dfs(arr, i, j));
        }
      }
    }
  }
  public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
	}
}

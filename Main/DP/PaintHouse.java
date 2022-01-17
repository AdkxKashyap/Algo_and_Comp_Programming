package Main.DP;

import java.util.Scanner;

public class PaintHouse {
  public static int minCost_tab(int[][] arr) {
  
    int r = arr[0][0];
    int g = arr[0][1];
    int b = arr[0][2];
    
    for(int i = 1; i < arr.length; i++) {
      int tmp_r = Math.min(g, b) + arr[i][0];
      int tmp_g = Math.min(r, b) + arr[i][1];
      int tmp_b = Math.min(r, g) + arr[i][2];

      r = tmp_r;
      g = tmp_g;
      b = tmp_g;

    }
    return Math.min(r, Math.min(g,b));
  }
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int[][] cost = new int[n][3];
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < 3; j++) {
        cost[i][j] = s.nextInt();
      }
    }
    int res = minCost_tab(cost);
    System.out.println(res);
  }
}

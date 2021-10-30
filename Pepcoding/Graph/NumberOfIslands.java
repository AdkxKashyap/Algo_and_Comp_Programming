package Graph;

import java.io.*;
import java.util.*;

//similar to get connected components
public class NumberOfIslands {

  public static int[][] dir = {{-1,0},  {0,1}, {1,0}, {0,-1}};
  public static int countIslands(int[][] arr){
    int count = 0;

    for(int i = 0; i < arr.length; i++){
      for(int j = 0; j < arr.length; j++){
        if(arr[i][j] == 0){
          gcc(arr, i, j);
          count++;
        }
      }
    }
    return count;
  }

  public static void gcc(int[][] arr, int r, int c){
    arr[r][c] = -1;
    //tldr direction
    for(int d = 0; d < 4; d++){
      int row= r + dir[d][0];
      int col = c + dir[d][1];

      if(row >= 0 && row < arr[0].length && col >= 0 && col < arr.length && arr[row][col] == 0){
        gcc(arr, r, c);
      }
    }
  }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      // write your code here
      int res = countIslands(arr);
      System.out.println(res);
   }

}

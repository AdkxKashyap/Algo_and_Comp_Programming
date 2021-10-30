import java.io.*;
import java.util.*;

public class NQueensCombination {

    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        // write your code here
        //direction - 1
        for(int r = row, c = col; c >= 0; c--) {
          if(chess[r][c] == true) {
            return false;
          }
        }
        //direction - 2
        for(int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
          if(chess[r][c] == true) {
            return false;
          }
        }
        //direction - 3
        for(int r = row, c = col; r >= 0; r--) {
          if(chess[r][c] == true) {
            return false;
          }
        }
       
        //direction - 4
        for(int r = row, c = col; c < chess[0].length && r >= 0; c++, r--) {
          if(chess[r][c] == true) {
            return false;
          }
        }
        return true;
    }
    //lc -> last cell visited, tq -> total queens
    public static void nQueens(int qpsf, boolean[][] chess, int tq, int lc) {
      if(qpsf == tq) {
        for(int i = 0; i < chess.length; i++) {
          for(int j = 0; j < chess[0].length; j++) {
            if(chess[i][j] == true) {
              System.out.print("q\t");
            }else System.out.print("-\t");
          }
          System.out.println();
        }
        System.out.println();
      }
      for(int i = lc + 1; i < chess.length * chess[0].length; i++) {
        int r = i/chess.length;
        int c = i%chess[0].length;
        if(IsQueenSafe(chess, r, c)) {
          chess[r][c] = true;
          nQueens(qpsf + 1, chess, tq, i);
          chess[r][c] = false;
        }
      }
    }
  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nQueens(0, chess, n, -1);
    }
}
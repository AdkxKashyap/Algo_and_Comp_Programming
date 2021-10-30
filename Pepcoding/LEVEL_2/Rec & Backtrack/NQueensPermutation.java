import java.io.*;
import java.util.*;

public class NQueensPermutation {

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        // write your code here
        int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
        for(int rad = 1; rad < chess.length; rad++) {
          for(int d = 0; d < dir.length; d++) {
            int r = row + rad * dir[d][0];
            int c = row + rad * dir[d][1];
            if(r >= 0 && c >= 0 && r < chess.length && c < chess[0].length && chess[r][c] != 0) return false;
          }
        }
        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        // write your code here
        if(qpsf == tq) {
          for(int i = 0; i < chess.length; i++) {
            for(int j = 0; j < chess[0].length; j++) {
              if(chess[i][j] != 0) {
                System.out.print("q" + chess[i][j] + "\t");
              }else System.out.print("-\t");
            }
            System.out.println();
          }
          System.out.println();
        }
        for(int i = 0; i < chess.length * chess[0].length; i++) {
          int r = i/chess.length;
          int c = i%chess.length;
          if(chess[r][c] == 0 && IsQueenSafe(chess, r, c)) {
            chess[r][c] = qpsf + 1;
            nqueens(qpsf + 1, tq, chess);
            chess[r][c] = 0;
          }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
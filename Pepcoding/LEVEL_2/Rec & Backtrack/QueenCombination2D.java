import java.io.*;
import java.util.*;

public class QueenCombination2D {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int row, int col){
        // write your code here
        if(qpsf == tq) {
          for(int i = 0; i < chess.length; i++) {
            for(int j = 0; j < chess.length; j++) {
              if(chess[i][j] == true) {
                System.out.print("q\t");
              }
              else System.out.print("-\t");
            }
            System.out.println();
          }
          System.out.println();
          return;
        }
        if(row == tq) return;
      for(int i = row; i < tq; i++) {
        for(int j = col + 1; j < tq; j++) {
          chess[i][j] = true;
          if(j + 1 < tq) {
            queensCombinations(qpsf + 1, tq, chess, i, j);
          }
          else {
            queensCombinations(qpsf + 1, tq, chess, i + 1, -1);
          }
          chess[i][j] = false;
        }
        col = -1;
      } 
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}
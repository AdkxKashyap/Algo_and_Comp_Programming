import java.util.*;
public class NQueens_Branch_Bound {
  //optimize isValid code from O(4N) to O(1)
  public static boolean[] col ;
  public static boolean[] nd;
  public static boolean[] rd;
  //arrays reqd to check validity
  public static void nQueens(int row, int tq, String asf) {
    if(row == tq) {
      System.out.println(asf + ".");
    }
    //row = col = tq
    for(int c = 0; c < tq; c++) {
      if(isSafeToPlace(row, c)) {
        col[c] = true;
        nd[row + c] = true;;
        rd[row - c + col.length - 1] = true;
        nQueens(row + 1, tq, asf + "," + row + "-" + col);
        col[c] = false;
        nd[row + c] = false;
        rd[row - c + col.length - 1] = false;
      }
    }
  }
  public static boolean isSafeToPlace(int r, int c) {
    //check in col
    if(col[c] == true) {
      return false;
    }
    if(nd[r+c] == true) return false;

    if(rd[r-c + col.length] == true) return false;

    return true;
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    //write your code here
    col = new boolean[n];
    nd = new boolean[2*n-1];
    rd = new boolean[2*n-1];
    nQueens(0, n, "");
  }
}

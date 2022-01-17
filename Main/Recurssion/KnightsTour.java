package Main.Recurssion;
import java.util.Scanner;

public class KnightsTour {
  public static int[][] dir={
    {-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}
  };
  public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int r=scanner.nextInt();
        int c=scanner.nextInt();
        int[][] chess= new int[n][n];
        chess[r][c]=1;
        printKnightsTour(chess, r, c, 1);
  }

  public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
      if(upcomingMove==Math.pow(chess.length, 2)){
        displayBoard(chess);
        return;
      }
      for(int d=0;d<dir.length;d++){
        int nrow=r + dir[d][0];
        int ncol=c + dir[d][1];
        if(isValidDir(chess, nrow, ncol)){
          chess[nrow][ncol]=upcomingMove+1;
          printKnightsTour(chess, nrow, ncol, upcomingMove+1);
          chess[nrow][ncol]=0;
        }
      }
  }
  public static boolean isValidDir(int[][] chess, int r, int c) {
      if(r<0 || r>=chess.length || c<0 || c>=chess.length || chess[r][c] != 0){
        return false;
      }

      return true;
  }
  public static void displayBoard(int[][] chess){
      for(int i = 0; i < chess.length; i++){
          for(int j = 0; j < chess[0].length; j++){
              System.out.print(chess[i][j] + " ");
          }
          System.out.println();
      }

      System.out.println();
  }
}

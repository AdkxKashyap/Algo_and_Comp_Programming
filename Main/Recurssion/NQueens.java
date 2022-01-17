package Main.Recurssion;
import java.io.*;
import java.util.*;

public class NQueens {
  public static int radius=0;
  
  public static void main(String[] args) throws Exception {
    Scanner scanner=new Scanner(System.in);
    int n =scanner.nextInt();
    int[][]arr=new int[n][n];
    printNQueens(arr,"",0);
    
  }

  public static void printNQueens(int[][] chess, String qsf, int row) {
    if(row==chess.length){
      System.out.println(qsf+".");
      return;
    }
    for(int col=0;col<chess[0].length;col++){
      if(isValidCoord(chess,row,col,chess.length,chess.length)){
        chess[row][col]=1;
        printNQueens(chess, qsf+""+row+"-"+col+", ", row+1);
      }
      chess[row][col]=0;
    }
  }

  public static boolean isValidCoord(int[][] chess,int r, int c,int radius,int n){
    int[][] dir={{-1,0},
              {-1,1},
              {0,1},
              {1,1},
              {1,0},
              {1,-1},
              {0,-1},
              {-1,-1}};
    for(int i=0;i<dir.length;i++){
      for(int rad=1;rad<radius;rad++){
        int rr=r+rad*dir[i][0];
        int cc=c+rad*dir[i][1];
        if(rr>=n || rr<0 || cc>=n ||cc<0)break;
        if(chess[rr][cc]==1)return false; 
      }  
    }
    return true;          
  }
}
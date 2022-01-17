import java.util.*;
import java.io.*;

public class Main {

  public static int countZeros(int[][]mat) {
    //write your code here
    int row = 0; 
    int col = mat[0].length-1;
    int count = 0;
    while(row < mat.length && col >= 0) {
        if(mat[row][col] == 0) {
            count += col+1;
            row++;
        } else col--;
    }
    return count;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[][]mat = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        mat[i][j] = scn.nextInt();
      }
    }

    System.out.println(countZeros(mat));
  }
}
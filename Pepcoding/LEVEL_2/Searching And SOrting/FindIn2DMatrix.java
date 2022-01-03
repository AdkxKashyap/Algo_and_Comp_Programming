import java.util.*;
import java.io.*;

public class Main {

  /*
   * your task is to complete this function which returns true if target exists in
   * the matrix else return false
   */
  public static int findRow(int[][] matrix, int target, int low, int high) {
    if (low > high)
      return -1;
    int colsize = matrix[0].length;
    int mid = (low + high) / 2;
    if (matrix[mid][0] <= target && matrix[mid][colsize - 1] >= target) {
      return mid;
    } else if (matrix[mid][0] > target) {
      return findRow(matrix, target, low, mid-1);
    } else
      return findRow(matrix, target, mid+1, high);
  }

  public static boolean find(int[][] matrix, int tar, int row, int low, int high) {
    if (low > high)
      return false;
    int mid = (low + high) / 2;
    if (matrix[row][mid] == tar)
      return true;
    else if (matrix[row][mid] > tar) {
      return find(matrix, tar, row, low, mid - 1);
    } else {
      return find(matrix, tar, row, mid + 1, high);
    }
  }

  public static boolean search(int[][] matrix, int target) {
    // write your code here
    int low = 0;
    int hi = matrix.length-1;
    int hc = matrix[0].length-1;
    int row = findRow(matrix, target, low, hi);
    if(row != -1) {
      return find(matrix, target, row, low, hc);
    }
    return false;
  }

  public static void main(String[] args) {
    // input work
    Scanner scn = new Scanner(System.in);
    int m = scn.nextInt();
    int n = scn.nextInt();

    int[][] matrix = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = scn.nextInt();
      }
    }

    int target = scn.nextInt();

    boolean isFound = search(matrix, target);
    System.out.println(isFound);

  }
}
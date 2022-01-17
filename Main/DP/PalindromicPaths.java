package Main.DP;
import java.util.*;
//check dp solution
class PalindromicPaths {
  public boolean isPalindrome(String str) {
    int l = 0;
    int r = str.length() - 1;
    while (l < r) {
      char left = str.charAt(l);
      char right = str.charAt(r);
      if (left != right)
        return false;
      l++;
      r--;
    }
    return true;
  }
  public  void helper(char[][] matrix, String asf, int i, int j, int[] count) {
    
    if (i == matrix.length - 1 && j == matrix[0].length - 1) {
      if (isPalindrome(asf + matrix[i][j])) {
        count[0]++;
      }
    }
    // call right
    if (j != matrix[0].length - 1) {
       helper(matrix, asf + matrix[i][j], i, j + 1, count);
    }
    if (i != matrix.length - 1) {
      helper(matrix, asf + matrix[i][j], i + 1, j, count);
    }
    return;
  }

  public  int countOfPalindromicPaths(char[][] matrix) {
    // Code here
    int[] res = new int[1];
     helper(matrix, "", 0, 0, res);
     return res[0];
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    sc.nextLine();
    char[][] chr = new char[n][m];
    for(int i = 0; i < n; i++){
      String line = sc.nextLine();
      for(int j = 0; j < m; j++){
        chr[i][j] = line.charAt(j);
     }
    
  }
  System.out.println(new PalindromicPaths().countOfPalindromicPaths(chr));
}
}

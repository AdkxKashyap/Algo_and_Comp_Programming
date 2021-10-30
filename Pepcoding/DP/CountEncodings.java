package DP;

import java.util.Scanner;

public class CountEncodings {
  public static int count_memo(String str, int indx, int[] dp) {
    if (indx == str.length())
      return 1;
    if (str.charAt(indx) == '0')
      return 0;
    if (dp[indx] != 0)
      return dp[indx];
    int s1 = str.charAt(indx) - '0';
    int count = count_memo(str, indx + 1, dp);
    if (indx + 1 < str.length()) {
      int s2 = str.charAt(indx + 1) - '0';
      if (s1 <= 2 && s2 <= 6) {
        count += count_memo(str, indx + 2, dp);
      }
    }
    return dp[indx] = count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    int[] dp = new int[str.length() + 1];
    int count = count_memo(str, 0, dp);
    System.out.println(count);
  }
}

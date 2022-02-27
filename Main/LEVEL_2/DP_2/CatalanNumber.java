import java.util.Scanner;
// Unique BST, Valleys adn mountains Count brackets, Triangulation use the same code. See Notes
public class CatalanNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int res = findCatalanNumber(n);
    System.out.println(res);
  }

  public static  int findCatalanNumber(int n) {
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2; i <= n; i++) {
      for(int j = 0; j < i; j++) {
        dp[i] += dp[j] * dp[i-j-1];
      }
    }
    return dp[n];
  }
}

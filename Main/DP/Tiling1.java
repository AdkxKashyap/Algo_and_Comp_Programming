package Main.DP;
import java.util.*;
//2*1 tiles
public class Tiling1 {
  //take long instead of int 
  public static int tiles(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;//flooe of length  1 can have only 1 possibility to fill
    dp[2] = 2;//flooe of length  2 can have only 2 possibility to fill

    for(int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int res = tiles(n);
    System.out.println(res);
  }
}

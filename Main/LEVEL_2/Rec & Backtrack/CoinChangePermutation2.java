import java.util.*;
public class CoinChangePermutation2 {
  public static void coinChange(int[] coins, int amtsf, int tamt, String asf) {
    if(amtsf == tamt) {
      System.out.println(asf + ".");
      return;
    }
    if(amtsf > tamt) return;
    for(int i = 0; i < coins.length; i++) {
      coinChange(coins, amtsf + coins[i], tamt, asf + coins[i] + "-");
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] coins = new int[n];
    for(int i = 0; i < n; i++) {
      coins[i] = sc.nextInt();
    }
    int amt = sc.nextInt();
    coinChange(coins, 0, amt, "");
  }
}

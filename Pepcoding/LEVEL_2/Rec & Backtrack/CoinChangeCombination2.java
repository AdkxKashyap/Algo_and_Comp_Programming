  import java.io.*;
  import java.util.*;

  public class CoinChangeCombination2 {

      public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
          // write your code here
          // int ans = amtsf;
          if(tamt == amtsf) {
            System.out.println(asf + ".");
            return;
          }
          if(i == coins.length) return;
          int coin = coins[i];
          int count = tamt/coin;
          //yes call
          for(int c = count; c > 0; c--) {
            String tmp = asf;
            for(int ans = 0; ans < c; ans++) {
              tmp += coin + "-";
            }
            coinChange(i + 1, coins, amtsf + coin * c, tamt , tmp);
          }
          coinChange(i + 1, coins, amtsf, tamt, asf);
      }

      public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int n = Integer.parseInt(br.readLine());
          int[] coins = new int[n];
          for (int i = 0; i < n; i++) {
              coins[i] = Integer.parseInt(br.readLine());
          }
          int amt = Integer.parseInt(br.readLine());
          coinChange(0, coins, 0, amt, "");
      }
  }
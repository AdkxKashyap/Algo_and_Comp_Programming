package Main.DP;

import java.util.Scanner;

//*see notes and video for tabular dp explaination
public class PaintFence {
  public static int paintFence_tab(int n, int k) {
    int lastTwoSame = 0;
    int lastTwoDiff = k;
    for(int i = 1; i < n; i++) {
      int tmp = lastTwoSame;
      lastTwoSame = lastTwoDiff;
      lastTwoDiff = (k-1) * (tmp + lastTwoDiff);
    }
    return lastTwoDiff + lastTwoSame;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int res = paintFence_tab(n, k);
    System.out.println(res);
  }
}

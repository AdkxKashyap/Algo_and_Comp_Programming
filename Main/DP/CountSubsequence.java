package Main.DP;

import java.util.Scanner;

//Count A+b+c+ Subsequences
public class CountSubsequence {
  public static int count(String str) {
    int a = 0;
    int b = 0;
    int c = 0;
    for(int i = 0; i < str.length(); i++) {
      if(str.charAt(i) == 'a') {
        a = 2 * a + 1;
      }
      else if(str.charAt(i) == 'b') {
        b = 2 * b + a;
      }
      else if(str.charAt(i) == 'c') {
        c = 2 * c + b;
      }
    }
    return c;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    int res = count(str);
    System.out.println(res);
  }
}

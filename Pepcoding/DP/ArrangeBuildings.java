package DP;

import java.util.Scanner;

public class ArrangeBuildings {

  public static long arrangeBuildings(int len) {
    long buildings = 1;
    long space = 1;
    for(int i = 2; i <= len; i++) {
      long tmp = buildings;
      buildings = space;
      space = tmp + space; 
    }
    long count  = buildings + space;
    return count * count;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long cnt = arrangeBuildings(n);
    System.out.println(cnt);
  }
}

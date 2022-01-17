import java.io.*;
import java.util.*;

public class LexicographicalNumbers {
  public static void print(int val, int n) {
    if(val > n) return;
      
      System.out.println(val);  
    for(int i = 0; i < 10; i++) {
        int num = val * 10 + i;  
        print(num, n);
    }
  }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		//write your code here
    for(int i = 1; i <= 9; i++) {
      print(i, n);
    }
	}
	
}
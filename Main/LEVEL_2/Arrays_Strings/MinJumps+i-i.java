import java.util.Scanner;

public class Main {
  // ~~~~~~~~~~~~User Section~~~~~~~~~~~
  public static int minJumps(int x) {
      // Write your code here
      int jumps = 1;
      int sum = 0;
      while(sum < x) {
        sum += jumps;
        jumps++;
      }
      //skip 1 jump
      if((sum-x)%2 == 0) return jumps-1;
      else {
        //take another jump
        sum = sum + jumps;
        if((sum-x) % 2 == 0) return jumps;
        //take 2 jums
        else return jumps+1;
      }
  }

  //~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int x = scn.nextInt();

      int jumps = minJumps(x);
      System.out.println(jumps);
  }
}

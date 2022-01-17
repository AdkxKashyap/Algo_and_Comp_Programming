package Main.Recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePaths {
  public static void main(String[] args) throws Exception {
    Scanner scanner=new Scanner(System.in);
    int n=scanner.nextInt();
    int m=scanner.nextInt();

    ArrayList<String>res=getMazePaths(0, 0, n-1, m-1);
    System.out.println(res);
  }

  // sr - source row
  // sc - source column
  // dr - destination row
  // dc - destination column
  public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
    if(sr==dr && sc==dc){
      ArrayList<String>bres=new ArrayList<>();
      bres.add("");
      return bres;
    }
    if(sr>dr || sc>dc){
      return new ArrayList<>();
      // return bres;
    }
    ArrayList<String>resH=getMazePaths(sr, sc+1, dr, dc);
    ArrayList<String> resV = getMazePaths(sr+1, sc, dr, dc);
    ArrayList<String> resMain=new ArrayList<>();
    for(String res:resH){
      resMain.add('h'+res);
    }
    for (String res : resV) {
      resMain.add('v' + res);
    }
    return resMain;
  }
}

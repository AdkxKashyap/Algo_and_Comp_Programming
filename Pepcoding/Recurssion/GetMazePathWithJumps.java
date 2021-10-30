package Recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathWithJumps {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();

    ArrayList<String> res = getMazePaths(0, 0, n - 1, m - 1);
    System.out.println(res);
  }

  // sr - source row
  // sc - source column
  // dr - destination row
  // dc - destination column
  public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
    if(sr>dr || sc>dc){
      return new ArrayList<>();
    }
    if(sr==dr && sc==dc){
      ArrayList<String>bres=new ArrayList<>();
      bres.add("");
      return bres;
    }
    ArrayList<String>resH;
    ArrayList<String>resV;
    ArrayList<String>resD;
    ArrayList<String>resMain=new ArrayList<>();
    for(int i=1;i<=dc;i++){
      resH=getMazePaths(sr, sc+i, dr, dc);
      for(String res:resH){
        resMain.add('h'+""+i+res);
      }
    }

    for (int i = 1; i <= dr; i++) {
      resV = getMazePaths(sr+i, sc, dr, dc);
      for (String res : resV) {
        resMain.add('v' +""+ i + res);
      }
    }

    for (int i = 1,j=1; i <= dr && j<=dc; i++,j++) {
      resD = getMazePaths(sr+i, sc + j, dr, dc);
      for (String res : resD) {
        resMain.add('d' +""+ i + res);
      }
    }
    return resMain;
  }
}

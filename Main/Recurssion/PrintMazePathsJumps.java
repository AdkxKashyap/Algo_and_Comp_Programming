package Main.Recurssion;
public class PrintMazePathsJava {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    getMazePaths(0, 0, n - 1, m - 1,"");
  }

  // sr - source row
  // sc - source column
  // dr - destination row
  // dc - destination column
  public static void getMazePaths(int sr, int sc, int dr, int dc,String psf) {
    if(sr>dr || sc>dc){
      return;
    }
    if(sr==dr && sc==dc){
      print(psf);
    }
    for(int i=1;i<=dc;i++){
      getMazePaths(sr, sc+i, dr, dc,psf+'h'+""+i);
    }

    for (int i = 1; i <= dr; i++) {
      getMazePaths(sr+i, sc, dr, dc,psf+'v'+""+i);
    }
    for (int i = 1, j = 1; i <= dr && j <= dc; i++, j++) {
      getMazePaths(sr + i, sc + j, dr, dc,psf+'d'+""+i);
    }
  }
}

package Main.LEVEL_2.Arrays_Strings;
import java.util.*;

public class BestMeetingPoint {

    // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static int minTotalDistance(int[][] grid) {
        // Write your code here
        ArrayList<Integer> xcoords = new ArrayList<Integer>();
        ArrayList<Integer> ycoords = new ArrayList<Integer>();
        //find x coord
        for(int i = 0; i < grid.length; i++) {
          for(int j = 0; j < grid[0].length; i++) {
            if(grid[i][j] == 1) xcoords.add(i);
          }
        }
        //find y coord
        for(int j = 0; j < grid[0].length; j++) {
          for(int i = 0; i < grid.length; i++) {
            if(grid[i][j] == 1) ycoords.add(j);
          }
        }
        int medianX = xcoords.get(xcoords.size()/2);
        int medianY = ycoords.get(ycoords.size()/2);

        int dist = 0;
        for(int xval : xcoords) {
          dist += Math.abs(medianX-xval);
        }
        for(int yval : ycoords) dist += Math.abs(medianY-yval);
        return dist;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();


        int[][] grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        int dist = minTotalDistance(grid);
        System.out.println(dist);
    }
}
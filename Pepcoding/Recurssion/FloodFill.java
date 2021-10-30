package Recurssion;
import Recurssion.*;
import java.io.*;
import java.util.*;

public class FloodFill {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    floodfill(arr,0,0,"");
  }

  
  public static void floodfill(int[][] maze,int i,int j,String asf) {
    if(i>=maze.length || j>=maze[0].length)return;
    if(i<0 || j<0)return;
    if(maze[i][j]>0)return;
    if(i == maze.length-1 && j == maze[0].length-1){
      System.out.println(asf);
      return;
    }
    maze[i][j]=1;//Since top and left is allowed we may end up going to same place again and again giving stack overflow err.
    //top
    floodfill(maze,i - 1,j,asf + 't');
    // left
    floodfill(maze, i, j - 1, asf + 'l');
    // down
    floodfill(maze, i + 1, j, asf + 'd');
    //right
    floodfill(maze,i,j + 1,asf + 'r');
    
   
    maze[i][j]=0;//reset value
    
  }
}
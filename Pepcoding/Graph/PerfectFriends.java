package Graph;

import java.io.*;
import java.util.*;

public class PerfectFriends {
   public static class Pair {
     int src;
     int nbr;

     public void Pair(int nbr, int src){
      this.src = src;
      this.nbr = nbr;
     }
   }

   public static int perfectFriends(ArrayList<Integer>[] graph){

    ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
    boolean[] vis = new boolean[graph.length];
    for(int i = 0; i < graph.length; i++){
      ArrayList<Integer> comp = new ArrayList<>();
      if(vis[i] == false){
        gcc(graph, i, vis, comp);
        comps.add(comp);
      }
    }
    int sum = comps.get(0).size();
    int count = 0;
    for(int i = 1; i < comps.size(); i++){
      count += sum * comps.get(i).size();
      sum += comps.get(i).size();
    }
    return count;
   }

   public static void gcc(ArrayList<Integer>[] graph, int src, boolean[] vis,ArrayList<Integer> comp){
     comp.add(src);
     vis[src] = true;
     for(int nbr : graph[src]){
       if(vis[nbr] == false){
        gcc(graph, nbr, vis, comp);
       }
     }
   }
   public static void main(String[] args) throws Exception {
     Scanner in = new Scanner(System.in);

      int n = in.nextInt();
      int k = in.nextInt();
      
      // write your code here

      ArrayList<Integer>[] graph = new ArrayList[n];
      for(int i = 0; i < n; i++){
        graph[i] = new ArrayList<>();
      }

      for(int j = 0; j < k; j++){
        int src = in.nextInt();
        int nbr = in.nextInt();
        graph[src].add(nbr);
        graph[nbr].add(src);
      }
      int res = perfectFriends(graph);
      System.out.println(res);
   }

}
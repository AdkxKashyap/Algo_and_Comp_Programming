package Main.Heaps;

import java.io.*;
import java.util.*;

public class MergeKSortedLst {

   public static class Pair implements Comparable<Pair>{
      int data;
      int list;

      public Pair(int data, int list){
         this.list = list;
         this.data = data;
      }

      @Override
      public int compareTo(Pair o) {
         // TODO Auto-generated method stub
         return this.data - o.data;
      }
   }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      // write your code here
      /** - get size of each list in lists
       * - init counter array 
       * - init pq with first values of each list
      */
      int[] size = new int[lists.size()];
      int[] counter = new int[lists.size()];
      PriorityQueue<Pair> pq= new PriorityQueue<>();
      int i = 0;
      for(ArrayList<Integer> lst : lists){
         size[i] = lst.size();
         counter[i] = 0;
         Pair np = new Pair(lst.get(0), i);
         pq.add(np);
         i++;
      }
      System.out.println(size[1]);
      //Contrsuct res list
      while(pq.size() != 0){
         Pair pr = pq.remove();
         rv.add(pr.data);
         if(counter[pr.list] != size[pr.list] - 1){
            ++counter[pr.list];
            ArrayList<Integer> list = lists.get(pr.list);
            int data = list.get(counter[pr.list]);
            Pair np = new Pair(data, pr.list);
            pq.add(np);
         }
      }
      return rv;
   }
    
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}

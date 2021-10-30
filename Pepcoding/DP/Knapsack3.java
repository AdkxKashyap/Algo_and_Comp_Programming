package DP;

import java.util.*;

//Fractional knapsack ujsing greedy
public class Knapsack3 {
  public static  class Pair implements Comparable<Pair> {
    int val;
    int wt;
    double frac;

    public Pair(int val, int wt) {
      this.val = val;
      this.wt = wt;
      this.frac = (val * 1.0)/wt;
    }
    @Override
    public int compareTo(Pair o) {
      if(this.frac > o.frac ) return 1;
      else if(this.frac < o.frac) return -1;
      else return 0;

    }
  }

  public static int maxValue(int[] wt, int[] val, int cap) {
    PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
    for(int i = 0; i < wt.length; i++) {
      pq.add(new Pair(val[i], wt[i]));
    }
    int profit = 0;
    while(pq.size() > 0 && cap > 0) {
      Pair p = pq.remove();
      if(cap >= p.wt) {
        profit += p.val;
        cap = cap - p.wt;
      }else {
        profit += cap * p.frac;
        cap = 0;
      }
    }
    return profit;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] val = new int[n];
    int[] wt = new int[n];
    for(int i = 0; i < n; i++) {
      val[i] = sc.nextInt();
    }
    for(int i = 0; i < n; i++) {
      wt[i] = sc.nextInt();
    }
    int cap = sc.nextInt();
    int res = maxValue(wt, val, cap);
    System.out.println(res);
  }
 }

import java.util.*;
import java.io.*;

public class Main {

  static class HitCounter {

    /** Initialize your data structure here. */
    ArrayDeque<Integer> dq;
    public HitCounter() {
      dq = new ArrayDeque<>();
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        dq.add(timestamp);
        int start = timestamp - 300 + 1;
        while(dq.peek() < start) {
          dq.remove();
        }
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
      int start = timestamp - 300 + 1;
      while(dq.peek() < start) {
        dq.remove();
      }
      return dq.size();
    }
  }
  public static void main(String[] args) throws java.lang.Exception {

    Scanner scn = new Scanner(System.in);

    HitCounter obj = new HitCounter();
    while (true) {
      String in = scn.next();

      if (in.equals("hit")) {
        obj.hit(scn.nextInt());
      } else if (in.equals("getHits")) {
        System.out.println(obj.getHits(scn.nextInt()));
      } else {
        break;
      }
    }
  }
}

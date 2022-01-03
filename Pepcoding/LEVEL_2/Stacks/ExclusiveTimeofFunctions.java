import java.util.Stack;

class Solution {
  class Pair {
  int id;
  int start;
  // ct - how much time its child ran
  int ct;

  Pair(int id, int start, int ct) {
    this.id = id;
    this.start = start;
    this.ct = ct;
  }
}

public int[] exclusiveTime(int n, List<String> logs) {
  Stack<Pair> stk = new Stack<>();
  int[] res = new int[n];
  for (String log : logs) {
    String[] str = log.split(":");
    if (str[1].equals("start")) {
      int id = Integer.parseInt(str[0]);
      int st = Integer.parseInt(str[2]);
      int ct = 0;
      Pair np = new Pair(id, st, ct);
      stk.push(np);
    } else {
          Pair rm = stk.pop();
      // this is the total interval includint runtime of child
      int interval = Integer.parseInt(str[2]) - rm.start + 1;
      // interval of only curr func, excl child
      int currInt = interval - rm.ct;
      res[rm.id] += currInt;
      // uodate child interval of parent func
         if(stk.size() != 0) 
          stk.peek().ct += interval;
    }

  }
  return res;
}
}
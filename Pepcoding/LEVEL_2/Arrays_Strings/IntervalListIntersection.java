//lc 986
class Solution {
  public int[][] intervalIntersection(int[][] intervalList1, int[][] intervalList2) {
      ArrayList<int[]> res = new ArrayList<>();
  int i = 0; 
  int j = 0;
  while(i < intervalList1.length && j < intervalList2.length) {
      int st = Math.max(intervalList1[i][0], intervalList2[j][0]);
      int end = Math.min(intervalList1[i][1], intervalList2[j][1]);
      if(st <= end) {
          //valid intersection
          int[] sublist = {st, end};
          res.add(sublist);
      }
      if(intervalList1[i][1] <  intervalList2[j][1]) {
          i++;
      }else {
          j++;
      }
  }
  return res.toArray(new int[res.size()][]);
  }
}
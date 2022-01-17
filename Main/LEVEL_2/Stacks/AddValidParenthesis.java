package Main.LEVEL_2.Stacks;
class Solution {
  //two solution.See leetcode solution for stack based solution
  public int minAddToMakeValid(String s) {
      int openP = 0; 
      int closedP = 0;
      for(int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if(ch == '(') openP++;
        else if(openP > 0) openP--;
        else closedP++;
      }
      return openP+closedP;
  }
}
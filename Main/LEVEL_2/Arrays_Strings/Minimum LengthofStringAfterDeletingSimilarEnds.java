public class Minimum LengthofStringAfterDeletingSimilarEnds {
  public int minimumLength(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right && s.charAt(left) == s.charAt(right)) {
          char ch = s.charAt(left);
          while(left < right && s.charAt(left) == ch) {
            left++;
          }
          //see lc test case why equality is needed
          while(left <= right && s.charAt(right) == ch) {
            right--;
          }
        }
        //see lc test case 
        // return right<=left ? 0 : right-left+1;
        return right-left+1;
  }
}

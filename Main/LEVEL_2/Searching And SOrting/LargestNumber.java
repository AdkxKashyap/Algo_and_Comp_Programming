import java.util.Arrays;

public class LargestNumber {
  public String largestNumber(int[] nums) {
    String[] ar = new String[nums.length];
    for(int i = 0; i < nums.length; i++) {
      ar[i] = nums[i] + "";
    }
    Arrays.sort(ar, (a,b) -> {
      Long n1 = Long.parseLong(a + b);
      Long n2 = Long.parseLong(b+a);
      if(n1 > n2) return 1;
      else if(n1 < n2) return -1;
      else return 0;
    });
    //edge case - all zeroes, only one zero is required.
    if(ar[nums.length-1].equals("0")) return 0 + "";
    StringBuilder res = new StringBuilder();
    for(int i = nums.length-1; i >= 0; i--) {
      res.append(ar[i]);
    }
    return res.toString();
  }
}

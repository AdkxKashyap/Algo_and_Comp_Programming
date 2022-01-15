import java.util.HashSet;

public class CheckArithmeticProgression {
  boolean checkIsAP(int arr[] ,int n)
  {
      // code here
      //to avoid arithmetic exception
      if(arr.length <= 1) return true;
      int max = Integer.MIN_VALUE;
   int min = Integer.MAX_VALUE;
   HashSet<Integer> set = new HashSet<>();
    //  int n = arr.length;
   for(int val : arr) {
     max = Math.max(max, val);
     min = Math.min(min, val);
     set.add(val);
   }
   int d = (max-min)/(n-1);
   for(int i = 0; i < n; i++) {
     if(!set.contains(min + i*d)) return false;
   }
   return true;
  }
}

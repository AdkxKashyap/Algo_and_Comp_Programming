//https://practice.geeksforgeeks.org/problems/digit-multiplier3000/1#
class DigitMultiplier {
  static String getSmallest(Long N) {
      // code here
      String res = "";
      if(N == 1) return "1";
      for(int i = 9; i>=2; i--) {
          while(N%i == 0) {
              res  = i+res;
              N /= i;
          }
      }
      return N != 1 ? "-1" : res;
  }
};
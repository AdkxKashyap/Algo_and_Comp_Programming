public class FaultyKeyboard {
  /**this is gfg problem. pepcoding question is different.
   * https://practice.geeksforgeeks.org/problems/faulty-keyboard2842/1
  */

  static int maxNatural(int M){
    int key = 0;
    int i = 0;
    while(key <= M) {
        i++;
        key += countDigits(i);
    }
    // code here
    return i-1;
}
static int countDigits(int num) {
    int count = 0;
    while(num != 0) {
        count++;
        num = num/10;
    }
    return count;
}
}

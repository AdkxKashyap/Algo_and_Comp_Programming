import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Result {

    /*
     * Complete the 'findSubstring' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String findSubstring(String s, int k) {
    // Write your code here
    /**azerdii
     * erdii
     */
      int max = 0;
      int i = 0;
      for(; i < k; i++) {
        char ch = s.charAt(i);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
          max++;
        }
      }
      int j = 0;
      int count = max;
      int st = 0;
      int end = k-1;
      for(; i < s.length();i++) {
        char rem = s.charAt(j);
        j++;
        char ch = s.charAt(i);
        if(rem == 'a' || rem == 'e' || rem == 'i' || rem == 'o' || rem == 'u') {
          count--;
        }
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
          count++;
        }
        if(count > max) {
          max = count;
          st = j;
          end = i;
        }
       }
       return s.substring(st, end+1);
    }

}



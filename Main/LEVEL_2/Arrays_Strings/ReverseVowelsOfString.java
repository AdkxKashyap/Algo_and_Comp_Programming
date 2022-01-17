package Main.LEVEL_2.Arrays_Strings;

import java.util.*;

public class ReverseVowelsOfString {
  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~
  public static String reverseVowels(String s) {
    // write your code here
    char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length-1;
        while(l < r) {
            while(l < r && !isVowel(arr[l])) l++;
            while(l < r && !isVowel(arr[r])) r--;
            
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
        return new String(arr);
  }
  
  public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    String res = reverseVowels(str);
    System.out.println(res);
  }
}


package Main.LEVEL_2.Arrays_Strings;
public class FaultyKeyboard2 {
  public static boolean isPossible(String name, String typed) {
    // Write your code here
    if (name.length() > typed.length())
      return false;
    int i = 0;
    int j = 0;
    while (i < name.length() && j < typed.length()) {
      if (name.charAt(i) == typed.charAt(j)) {
        i++;
        j++;
      } else if (i > 0 && name.charAt(i - 1) == typed.charAt(j)) {
        j++;
      } else
        return false;
    }
    while (j < typed.length()) {
      if (name.charAt(i - 1) == typed.charAt(j)) {
        j++;
      } else
        return false;
    }
    return i < name.length() ? false : true;
  }
}

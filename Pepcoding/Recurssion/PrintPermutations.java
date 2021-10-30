package Recurssion;
//**Here order matters.Order does not matter in the leetcode version of permutation.
import java.util.ArrayList;
import java.util.Scanner;

public class PrintPermutations {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    String str=in.next();
    printPermutations(str,"");
  }

  public static void printPermutations(String str,String asf) {
    if(str.length()==0){
      System.out.println(asf);
      return;
    }
    for(int i=0;i<str.length();i++){
      char ch=str.charAt(i);
      String roq=str.substring(0,i)+str.substring(i+1);
      printPermutations(roq,asf+ch);
    }
  }
}

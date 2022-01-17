package Main.Recurssion;
import java.util.Scanner;
import java.io.*;
import java.util.*;
//bottom-up approach
public class PrintSubsequence {
    public static void main(String[] args) throws Exception {
      Scanner sc= new Scanner(System.in);
      String str=sc.next();
      printSS(str,"");
    }

    public static void printSS(String str, String ans) {
      if(str.length()==0){
        return;
      }
      char c=str.charAt(0);
      String roq=str.substring(1);
      printSS(roq,ans+c);
      System.out.println(ans);
      printSS(roq,ans);
    }
}

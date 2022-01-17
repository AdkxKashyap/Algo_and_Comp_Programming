package Main.Recurssion;

import java.util.Scanner;

public class PrintEncodings {
  public static void main(String[] args) throws Exception {
    Scanner sc=new Scanner(System.in);
    String str=sc.next();
    printEncodings(str,"");
  }

  public static void printEncodings(String str,String asf) {
    if(str.length()==0){
      System.out.println(asf);
      return;
    }
    int n1=str.charAt(0)-'0';
    if(n1==0)return;
    char code1=(char)(n1+'a'-1);
    printEncodings(str.substring(1,str.length()),asf+code1);

    if(str.length()>1){
      int n2 = str.charAt(1) - '0';
      if(n1*10+n2>26)return;
      char code2 = (char) (n1*10+n2 + 'a' - 1);
      printEncodings(str.substring(2, str.length()),asf+code2);
    }
    
  }
}

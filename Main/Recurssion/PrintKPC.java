package Main.Recurssion;
public class PrintKPC {
  static String[] codes={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
  public static void main(String[] args) throws Exception {
      Scanner sc= new Scanner(System.in);
      String str=sc.next();
      printKPC(str,"");
  }

  public static void printKPC(String str,String ans) {
    if(str.length()==0){
      System.out.println(ans);
      return;
    }
    int index=str.charAt(0)-'0';
    String code=codes[index];
    String roq=str.substring(1);
    for(int i=0;i<code.length();i++){
      char ch=code.charAt(i);
      printKPC(roq, ans + ch);
    }
  }
}

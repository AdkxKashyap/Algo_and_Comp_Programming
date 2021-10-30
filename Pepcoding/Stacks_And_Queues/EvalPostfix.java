package Stacks_And_Queues;

import java.util.*;
//eval postfix
//postfix->prefix,pstfix->infix
public class EvalPostfix {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String exp = in.nextLine();
    int res = evalPostfix(exp);
    String resToPrefix=postfixToPrefix(exp);
    String resToInfix= postfixToInfix(exp);
    System.out.println(res);
    System.out.println(resToInfix);
    System.out.println(resToPrefix);
  }
  
  public static int eval(char op, int val1, int val2) {
    if (op == '*')
      return val1 * val2;
    if (op == '/')
      return val1 / val2;

    if (op == '-')
      return val1 - val2;
    if (op == '+')
      return val1 + val2;
    else
      return 0;
  }

  public static int evalPostfix(String exp){
    Stack<Integer> valStk = new Stack<>();

    for(int i=0;i<exp.length();i++){
      char ch=exp.charAt(i);
      if(ch>='0' && ch<='9'){
        valStk.push(ch-'0');
      }
      else{
        int val2=valStk.pop();
        int val1=valStk.pop();
        int res=eval(ch,val1,val2);
        valStk.push(res);
      }
    }
    return valStk.pop();
  }

  public static String postfixToPrefix(String exp) {
    Stack<String> valStk = new Stack<>();
   

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);
      if (ch >= '0' && ch <= '9') {
        valStk.push(""+ch);
      } else {
        String val2 = valStk.pop();
        String val1 = valStk.pop();
        String res = ch+val1+val2;
        valStk.push(res);
      }
    }
    return valStk.pop();
  }

  public static String postfixToInfix(String exp) {
    Stack<String> valStk = new Stack<>();

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);
      if (ch >= '0' && ch <= '9') {
        valStk.push("" + ch);
      } else {
        String val2 = valStk.pop();
        String val1 = valStk.pop();
        String res ="("+ val1 + ch + val2+")";
        valStk.push(res);
      }
    }
    return valStk.pop();
  }
}

package Stacks_And_Queues;

import java.util.*;

//Eval,prefix->infix,postfix
public class EvalPrefix {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String exp = in.nextLine();
    int res = evalPrefix(exp);
    String res2 = prefixToInfix(exp);
    String res3 = prefixToPostfix(exp);

    System.out.println(res);
    System.out.println(res2);
    System.out.println(res3);
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

  // similar to postfix,run loop end to start
  public static int evalPrefix(String exp) {
    Stack<Integer> valStk = new Stack<>();
    for (int i = exp.length() - 1; i >= 0; i--) {
      char ch = exp.charAt(i);
      if (ch >= '0' && ch <= '9') {
        valStk.push(ch - '0');
      } else {
        int val1 = valStk.pop();
        int val2 = valStk.pop();
        int res = eval(ch, val1, val2);
        valStk.push(res);
      }
    }
    return valStk.pop();
  }

  public static String prefixToInfix(String exp) {
    Stack<String> valStk = new Stack<>();
    for (int i = exp.length() - 1; i >= 0; i--) {
      char ch = exp.charAt(i);
      if (ch >= '0' && ch <= '9') {
        valStk.push(ch + "");
      } else {
        String val1 = valStk.pop();
        String val2 = valStk.pop();
        String res = "(" + val1 + ch + val2 + ")";
        valStk.push(res);
      }
    }
    return valStk.pop();
  }

  public static String prefixToPostfix(String exp) {
    Stack<String> valStk = new Stack<>();
    for (int i = exp.length() - 1; i >= 0; i--) {
      char ch = exp.charAt(i);
      if (ch >= '0' && ch <= '9') {
        valStk.push(ch + "");
      } else {
        String val1 = valStk.pop();
        String val2 = valStk.pop();
        String res = val1 + val2 + ch;
        valStk.push(res);
      }
    }
    return valStk.pop();
  }
}

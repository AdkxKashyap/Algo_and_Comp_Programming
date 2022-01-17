package Main.Stacks_And_Queues;

import java.util.*;

//infix->postfix,prefix
public class EvalInfix2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String exp = in.nextLine();
    String res1 = infixToPrefix(exp);
    String res2 = infixToPostfix(exp);
    System.out.println(res1);
    System.out.println(res2);
  }

  public static int priority(char op) {
    if (op == '*' || op == '/') {
      return 2;
    } else if (op == '+' || op == '-')
      return 1;
    else
      return 0;
  }

  public static String infixToPrefix(String exp) {
    Stack<String> valStk = new Stack<>();
    Stack<Character> opStk = new Stack<>();

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);
      if (ch == ' ')
        continue;
      if (ch >= 'a' && ch <= 'z') {
        valStk.push(ch + "");
      } else if (ch == '(') {
        opStk.push(ch);
      } else if (ch == ')') {
        while (opStk.peek() != '(') {
          char op = opStk.pop();
          String val2 = valStk.pop();
          String val1 = valStk.pop();
          String res = op + val1 + val2;
          valStk.push(res);
        }
        opStk.pop();
      } else {
        while (opStk.size() > 0 && opStk.peek() != '(' && priority(ch) <= priority(opStk.peek())) {
          char op = opStk.pop();
          String val2 = valStk.pop();
          String val1 = valStk.pop();
          String res = op + val1 + val2;
          valStk.push(res);
        }
        opStk.push(ch);
      }

    }
    while (opStk.size() > 0) {
      char op = opStk.pop();
      String val2 = valStk.pop();
      String val1 = valStk.pop();
      String res = op + val1 + val2;
      valStk.push(res);
    }
    return valStk.pop();
  }

  public static String infixToPostfix(String exp) {
    Stack<String> valStk = new Stack<>();
    Stack<Character> opStk = new Stack<>();

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);
      if (ch == ' ')
        continue;
      if (ch >= 'a' && ch <= 'z') {
        valStk.push(ch + "");
      } else if (ch == '(') {
        opStk.push(ch);
      } else if (ch == ')') {
        while (opStk.peek() != '(') {
          char op = opStk.pop();
          String val2 = valStk.pop();
          String val1 = valStk.pop();
          String res = val1 + val2 + op;
          valStk.push(res);
        }
        opStk.pop();
      } else {
        while (opStk.size() > 0 && opStk.peek() != '(' && priority(ch) <= priority(opStk.peek())) {
          char op = opStk.pop();
          String val2 = valStk.pop();
          String val1 = valStk.pop();
          String res = val1 + val2 + op;
          valStk.push(res);
        }
        opStk.push(ch);
      }

    }
    while (opStk.size() > 0) {
      char op = opStk.pop();
      String val2 = valStk.pop();
      String val1 = valStk.pop();
      String res = val1 + val2 + op;
      valStk.push(res);
    }
    return valStk.pop();
  }
}

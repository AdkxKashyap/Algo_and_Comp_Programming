package Stacks_And_Queues;

import java.util.*;

public class EvalInfix {
  public static void main(String[] args) {
    Scanner in =new Scanner(System.in);
    String exp=in.nextLine();
    int res=evalInfix(exp);
    System.out.println(res);
  }
   public static int priority(char op){
     if(op=='*' || op=='/'){
      return 2;
     }
     else if(op=='+' || op=='-')return 1;
     else return 0;
   }

   public static int eval(char op,int val1,int val2){
    if(op == '*')return val1 * val2;
    if(op == '/')return val1 / val2;

    if (op == '-')
       return val1 - val2;
    if (op == '+')
       return val1 + val2;
      else return 0;
   }

   public static int evalInfix(String exp){
     Stack<Integer>valStk=new Stack<>();
     Stack<Character>opStk=new Stack<>();

     for(int i=0;i<exp.length();i++){
       char ch=exp.charAt(i);
       if(ch==' ')continue;
       if(ch >= '0' && ch <= '9'){
         valStk.push(ch - '0');
       }
       else if(ch == '('){
         opStk.push(ch);
       }
       else if(ch == ')'){
         while(opStk.peek() != '('){
           char op=opStk.pop();
           int val2=valStk.pop();
           int val1=valStk.pop();
           int res=eval(op, val1, val2);
           valStk.push(res);
         }
         opStk.pop();
       }
       else{
         while(opStk.size() >0 && opStk.peek()!= '(' && priority(ch)<=priority(opStk.peek())){
           char op=opStk.pop();
           int val2=valStk.pop();
           int val1=valStk.pop();
           int res=eval(op, val1, val2);
           valStk.push(res);
         }
         opStk.push(ch);
       }
      
     }
     while (opStk.size() > 0) {
       char op = opStk.pop();
       int val2 = valStk.pop();
       int val1 = valStk.pop();
       int res = eval(op, val1, val2);
       valStk.push(res);
     }
     return valStk.pop();
   }
   
}

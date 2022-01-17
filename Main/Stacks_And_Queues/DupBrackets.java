package Main.Stacks_And_Queues;
import java.io.*;
import java.util.*;

public class DupBrackets {
  public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    String str=scanner.nextLine();
    findDup(str);
  }
  public static void findDup(String str){
    Stack<Character>stk=new Stack<>();
    for(int i=0;i<str.length();i++){
     if(str.charAt(i) != ')'){
       stk.push(str.charAt(i));
     }
     else{
       if(stk.peek() == '('){
         System.out.println(true);
         return;
       }
       while(stk.peek()!= '('){
         stk.pop();
       }
       stk.pop();
     }
    }
    System.out.println(false);
  }
}

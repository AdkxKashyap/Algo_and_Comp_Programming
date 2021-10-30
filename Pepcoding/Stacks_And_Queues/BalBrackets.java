import java.util.Stack;

public class BalBrackets {
  public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    String str=scanner.nextLine();
    isBalanced(str);
  }

  public static void isBalanced(String str){
    Stack<Character>stk=new Stack<>();
    for(int i=0;i<str.length();i++){
      char ch=str.charAt(i);
      if(ch == '(' || ch == '[' || ch == '{'){
        stk.push(ch);
      }
      else if(ch == ')'){
        if(stk.empty() || stk.peek() != '('){
          System.out.println(false);
          return;
        }
        stk.pop();
      }

      else if (ch == ']') {
        if (stk.empty() || stk.peek() != '[') {
          System.out.println(false);
          return;
        }
        stk.pop();
      }

      else if (ch == '}') {
        if (stk.empty() || stk.peek() != '{') {
          System.out.println(false);
          return;
        }
        stk.pop();
      }  
    }
    if(stk.size()!=0){
      System.out.println(false);
      return;
    }
    System.out.println(true);
  }
}

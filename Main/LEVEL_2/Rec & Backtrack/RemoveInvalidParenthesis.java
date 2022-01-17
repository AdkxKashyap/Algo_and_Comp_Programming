import java.io.*;
import java.util.*;

public class Main {
//set is taken so that duplicate solutions do not come.For ()())() two same answers will be there
	public static void solution(String str, int minRemoval, HashSet<String> ans) {
		//write your code here
    if(minRemoval == 0) {
      int minRemove = getMin(str);
      if(minRemove == 0) {
        if(!ans.contains(str)) {
            ans.add(str);
          System.out.println(str);
        }
      }
      return;
    }
    for(int i = 0; i < str.length(); i++) {
      //remove ith char
      //from 0 - i-1 th char
      String left = str.substring(0, i);
      //from i+1th char
      String right = str.substring(i+1);
      solution(left + right, minRemoval - 1, ans);
    }
	}
  //returns min number of parentheses to be removed to  
	public static int getMin(String str){
		//write your code here
    Stack<Character> stk = new Stack<>();
    for(int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if(ch == '(') {
        stk.push(ch);
      }else {
        if(stk.size() == 0) stk.push(ch);
        else if(stk.peek() == ')') stk.push(ch);
        else if(stk.peek() == '(') stk.pop();
      }
      //will return count of unnecessary parenthesis
    }
		return stk.size();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		
		solution(str, getMin(str),new HashSet<>());
	}
		
}
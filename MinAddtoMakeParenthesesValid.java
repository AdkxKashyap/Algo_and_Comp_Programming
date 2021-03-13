import java.util.Stack;

public class MinAddtoMakeParenthesesValid {
    boolean isValid(char c1,char c2){
        return c1=='(' && c2==')'?true:false;
    }
    public int minAddToMakeValid(String S) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<S.length();i++){
            if(!st.isEmpty() && isValid(st.peek(), S.charAt(i))){
                st.pop();
            }
            else{
                st.push(S.charAt(i));
            }
        }
        return st.size();
    }
}

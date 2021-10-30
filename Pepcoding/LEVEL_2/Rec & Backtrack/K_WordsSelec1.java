import java.io.*;
import java.util.*;

public class K_WordsSelec1 {

//dublicates not allowed
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    int k = scn.nextInt();
    
    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for(char ch : str.toCharArray()){
        if(unique.contains(ch)== false){
            unique.add(ch);
            ustr+=ch;
        }
    }
    
    combination(0,ustr,0,k,"");
  }
  
  
  public static void combination(int chi,String ustr,int ssf, int ts, String asf ){
      
    if(ssf == ts) {
      System.out.println(asf);
      return;
    }
      //level->char, options->box
      
    for(int i = chi + 1; i < ustr.length(); i++) {
      char ch = ustr.charAt(i);
      combination(chi, ustr, ssf + 1, ts, asf + ch);
    }
  }

}
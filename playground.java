import java.util.HashSet;
import java.util.Set;

public class playground {
    public static void main(String[] args) {
        // int array[]=new int[10];
        // if(array[0]==0){
          String s="aAabB";
          Set<Character>set=new HashSet<>();
          for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
          }
          for(char i:set){
            System.out.println(i);
          }
        }
    }


import java.util.*;

class StreamChecker {
  public static class Node {
    Node[] children;
    boolean isEnd ;
    Node() {
      children = new Node[26];
      isEnd = false;
    }
  }
  private final Node root ;
  private final ArrayList<Character> chars ;
  public StreamChecker(String[] words) {
       root = new Node();
       chars = new ArrayList<>();
      for(String wd : words) {
        insert(wd, root);
      }
  }
  
  public boolean query(char letter) {
      chars.add(letter);
      Node cur = root;
      for(int i = chars.size()-1; i >= 0; i--) {
        char ch = chars.get(i);
        cur = cur.children[ch-'a'];
        if(cur == null) {
          return false;
        }
        if(cur.isEnd == true) return true;
      }
      return false;
  }
  public  void insert(String word, Node root) {
    Node cur = root;
    //insert in reverse
    for(int i = word.length()-1; i >= 0; i--) {
      char ch = word.charAt(i);
      if(cur.children[ch - 'a'] == null) {
        cur.children[ch - 'a'] = new Node();
      }
      cur = cur.children[ch - 'a'];
    }
    cur.isEnd = true;
  }
}

/**
* Your StreamChecker object will be instantiated and called as such:
* StreamChecker obj = new StreamChecker(words);
* boolean param_1 = obj.query(letter);
*/
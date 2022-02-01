public class DesignAndAddSearchWords {
  class Node {
    Node[] children ;
    boolean isEnd;

    Node() {
      children = new Node[26];
      isEnd = false;
    }
    public boolean find(String word, int idx) {
      
     
      if(idx == word.length()) {
       return isEnd;
      }
      char ch = word.charAt(idx);
      if(ch == '.') {
        for(Node n : this.children) {
          if(n != null && n.find(word, idx+1)) return true;
        }
        return false;
      } else {
        if(this.children[ch-'a'] == null) return false;
        else {
          return this.children[ch-'a'].find(word, idx+1);
        }
      }
    }
  }
  private final Node root = null;
  public WordDictionary() {
    root = new Node();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    Node curr = root;
    for(char ch : word.toCharArray()) {
      Node[] children = curr.children;
      if(children[ch-'a'] == null) {
        children[ch-'a'] = new Node();
      } 
      curr = children[ch-'a'];
    }
    curr.isEnd = true;
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot
   * character '.' to represent any one letter.
   */
  public boolean search(String word) {
   return root.find(word, 0);
  }
}

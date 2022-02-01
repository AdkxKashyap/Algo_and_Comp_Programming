package Main.LEVEL_2.Trie;
//lc720
class Solution {
  public static class Node {
    Node[] children;
    String str;
    Node() {
      children = new Node[26];
      str = null;
    }
  }
  public String ans = "";
  public String longestWord(String[] words) {
      Node root = new Node();
      for(String wd : words) {
        insert(wd, root);
      }
      dfs(root);
      return ans;
  }
  public  void insert(String word, Node root) {
    Node cur = root;
    for(char ch : word.toCharArray()) {
      if(cur.children[ch - 'a'] == null) {
        cur.children[ch - 'a'] = new Node();
      }
      cur = cur.children[ch - 'a'];
    }
    cur.str = word;
  }
  public  void dfs(Node root) {
    for(Node child : root.children) {
      /**if child.str exists in arr only than proceed further
       * eg - [c, ca, cat, bat]-> cat
       *  when dfs reaches b , b.isend = false so dfs will not proceed further
      */
      
      if(child != null && child.str != null) {
        if(child.str.length() > ans.length()) {
          ans = child.str;
        }
        dfs(child);
      } 
    }
  }
}
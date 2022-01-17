package Main.LEVEL_2.Trie;
class Solution {
  public static class Node {
      Node[] children;
      String str ;
      Node() {
          children = new Node[26];
          str = null;
      }
  }
  public String replaceWords(List<String> dictionary, String sentence) {
      Node root = new Node();
      for(String wd : dictionary) {
          insert(wd, root);
      }
      String[] tokens = sentence.split(" ");
      return buildSentence(root, tokens);
      
  }
  
  public String buildSentence(Node root, String[] tokens) {
      StringBuilder sb = new StringBuilder();
      for(String str : tokens) {
          String res = find(str, root);
          if(res != null) {
              sb.append(res);
          } else {
              sb.append(str);
          }
          sb.append(" ");
      }
      return sb.substring(0, sb.length()-1).toString();
  }
  
  public String find(String word, Node root) {
      Node cur = root;
      for(char ch : word.toCharArray()) {
          if(cur.children[ch-'a'] != null) {
              if(cur.children[ch-'a'].str != null) {
                  return cur.children[ch-'a'].str;
              } else {
                  cur = cur.children[ch-'a'];
              }
          } else {
              return null;
          }
      }
      return null;
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
}
package Main.LEVEL_2.Trie;
import java.util.HashMap;

class MapSum {
  private final Node root ;
  private final HashMap<String, Integer> map ;
  public MapSum() {
      root = new Node();
      map = new HashMap<>();
  }
   static class Node {
    Node[] children;
    int prefixSum;
    Node() {
      children = new Node[26];
      prefixSum = 0;
    }
  }
  public void insert(String key, int val) {
      //if prev value exists remove that and place new val
      int del = val - map.getOrDefault(key, 0);
      map.put(key, val);
      Node cur = root;
      for(int i = 0; i < key.length(); i++) {
        char ch = key.charAt(i);
        if(cur.children[ch-'a'] == null) {
          cur.children[ch-'a'] = new Node();
        }
        
        cur = cur.children[ch-'a'];
        cur.prefixSum += del;
      }
  }
  
  public int sum(String prefix) {
    Node cur = root;
      for(int i = 0; i < prefix.length(); i++) {
        char ch = prefix.charAt(i);
        if(cur.children[ch-'a'] != null) {
          cur = cur.children[ch-'a'];
        }else return 0;
      }
      return cur.prefixSum;
  }
}

/**
* Your MapSum object will be instantiated and called as such:
* MapSum obj = new MapSum();
* obj.insert(key,val);
* int param_2 = obj.sum(prefix);
*/
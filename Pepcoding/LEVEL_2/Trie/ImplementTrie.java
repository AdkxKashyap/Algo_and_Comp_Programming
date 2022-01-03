class ImplementTrie {
  final private Node root = new Node();
  public Trie() {
        root = new Node();
    }

  public static class Node {
    Node[] children = null;
    boolean isEnd = false;

    Node() {
      this.children = new Node[26];
    }
  }

  

  public void insert(String word) {
    int n = word.length();
    Node curr = root;
    for (int i = 0; i < n; i++) {
      Node[] arr = curr.children;
      char ch = word.charAt(i);
      if (arr[ch - 'a'] == null) {
        arr[ch - 'a'] = new Node();
      }
      curr = arr[ch - 'a'];
    }
    curr.isEnd = true;
  }

  public boolean search(String word) {
    Node cur = root;
    
    for (int i = 0; i < word.length(); i++) {
      Node[] arr = cur.children;
      char ch = word.charAt(i);
      if (arr[ch - 'a'] == null)
        return false;
      cur = arr[ch - 'a'];
    }
    return cur.isEnd;
  }

  public boolean startsWith(String prefix) {
    Node cur = root;
    
    for (int i = 0; i < prefix.length(); i++) {
      Node[] arr = cur.children;
      char ch = prefix.charAt(i);
      if (arr[ch - 'a'] == null)
        return false;
      cur = arr[ch - 'a'];
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
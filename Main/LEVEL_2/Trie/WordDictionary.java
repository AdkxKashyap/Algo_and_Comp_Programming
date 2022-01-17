package Main.LEVEL_2.Trie;
import java.io.*;
import java.util.*;

public class Main {
  public static class WordDictionary {
    public static class Node {
      Node[] children = null;
      boolean isEnd = false;

      Node() {
        children = new Node[26];
      }
    }

    private final Node root;

    public WordDictionary() {
      root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
      Node curr = root;
      return helper(curr, word, 0);
    }

    public static boolean helper(Node curr, String word, int idx) {
      if (idx == word.length()) {
        if (curr.isEnd == true)
          return true;
        return false;
      }
      Node[] arr = curr.children;
      char ch = word.charAt(idx);
      if (ch == '.') {
        for (Node chld : arr) {
          if (chld != null && helper(chld, word, idx + 1) == true) {
              return true;
          } 
        }
      } else {
        if (arr[ch - 'a'] != null) {
          return helper(arr[ch - 'a'], word, idx + 1);
        } else
          return false;
      }
      return false;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    WordDictionary obj = new WordDictionary();

    while (read.ready()) {
      String inp[] = read.readLine().split(" ");

      if (inp[0].equals("addWord")) {
        obj.addWord(inp[1]);
      } else if (inp[0].equals("search")) {
        System.out.println(obj.search(inp[1]));
      }
    }

  }
}

import java.io.*;
import java.net.Inet4Address;
import java.util.*;
//lc https://leetcode.com/problems/word-search-ii/
public class WordSearch2 {
  public static class Node {
    Node[] children ;
    String fword;
    Node() {
      children = new Node[26];
      fword = "";
    }
  }
  // public static Node root ;
  public static ArrayList<String> findWords(char[][] board, String[] words) {
    Node root = new Node();
    for(String word : words) {
      insert(word, root);
    }
    int[][] vis = new int[board.length][board[0].length];
    ArrayList<String> res = new ArrayList<>();
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, res, root, vis);
      }
    }
    
    return res;
  }
  public static void insert(String word, Node root) {
    Node curr = root;
    for(int i = 0; i < word.length(); i++) {
      Node[] arr = curr.children;
      char ch = word.charAt(i);
      if(arr[ch - 'a'] == null) {
        arr[ch-'a'] = new Node();
      } 
      curr = arr[ch - 'a'];
    }
    //INSTEAD OF BOOLEAN JUST PLACE THE WORD.sINCE WE WILL HAVE THE ENTIRE WORD NO NEED TO USE A STRING OF STRINGBUILDER FOR ANS SO FAR
    curr.fword = word;
  }
                                //top
  public static int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
  public static void dfs(char[][] board, int i, int j, List<String> ans, Node curr, int[][] vis) {
    if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || vis[i][j] == 1) return;
    
    
    char ch = board[i][j];
    Node[] arr = curr.children;
    if(arr[ch-'a'] != null) {
      if(!arr[ch-'a'].fword.equals("")) {
        ans.add(arr[ch-'a'].fword);
        //make fword empty so that we get the word only once
        arr[ch-'a'].fword = "";
      }
      vis[i][j] = 1;
      //traverse 4-dir
      for(int d = 0; d < 4; d++) {
        int r = i + dir[d][0];
        int c = j + dir[d][1];
        dfs(board, r, c, ans,arr[ch-'a'], vis);
      }
      vis[i][j] = 0;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int m = Integer.parseInt(read.readLine());
    char[][]board = new char[n][];
    for (int i = 0; i < n; i++) {
      board[i] = read.readLine().trim().toCharArray();
    }
    int count = Integer.parseInt(read.readLine());
    String words[] = new String[count];
    for (int i = 0; i < count; i++) {
      words[i] = read.readLine();
    }

    ArrayList<String> result = findWords(board, words);
    Collections.sort(result);
    System.out.println(result);

  }
}

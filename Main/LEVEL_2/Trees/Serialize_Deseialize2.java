package Main.LEVEL_2.Trees;
//for N - ary tree.
import java.util.*;

public class Serialize_Deseialize2 {
  public static Scanner scn = new Scanner(System.in);

  static class Node {
    public int val;
    public ArrayList<Node> children;

    public Node() {
      children = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
      val = _val;
      children = _children;
    }
  }
    public static void se_helper(Node root, StringBuilder sb) {
        if(root == null) {
            sb.append("null#");
            return;
        }
        sb.append(root.val + "#");
        for(Node child : root.children) {
            se_helper(child, sb);
        }
        sb.append("null#");
    }
  // Encodes a tree to a single string.
  public static String serialize(Node root) {
    if(root == null) {
        return "null";
    }
    StringBuilder sb = new StringBuilder();
    se_helper(root, sb);
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public static Node deserialize(String str) {
      if(str.equals("null")) return null;
    String[] data = str.split("#");
    Stack<Node> stk = new Stack<>();
    Node root = new Node(Integer.parseInt(data[0]));
    stk.push(root);
    int idx = 1;
    while(idx < data.length) {
        if(data[idx].equals("null")) {
            stk.pop();
            idx++;
        }else {
            Node par = stk.peek();
            int val = Integer.parseInt(data[idx]);
            Node nn = new Node(val);
            par.children.add(nn);
            stk.push(nn);
            idx++;
        }
    }
    return root;
  }

  // input_Section=================================================
  public static void display(Node node) {
    if (node == null)
      return;

    StringBuilder sb = new StringBuilder();
    sb.append(node.val + " -> ");
    for (Node child : node.children) {
      sb.append(child.val + " ");
    }
    System.out.println(sb.toString());

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node createTree(String[] arr) {
    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length - 1; i++) {
      String s = arr[i];
      if (s.equals("null")) {
        Node node = st.pop();
        st.peek().children.add(node);
      } else {
        Node node = new Node(Integer.parseInt(s));
        st.push(node);
      }
    }

    return st.size() != 0 ? st.pop() : null;
  }

  public static void solve() {
    String str = scn.nextLine();
    String[] arr = str.split(" ");

    Node root = createTree(arr);
    String s = serialize(root);
    display(deserialize(s));
  }

  public static void main(String[] args) {
    solve();
  }
}

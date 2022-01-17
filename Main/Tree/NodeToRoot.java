package Main.Tree;
import java.util.*;
//see find
public class NodeToRoot {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
    // write your code here
    if (node.data == data) {
      ArrayList<Integer> ret = new ArrayList<>();
      ret.add(data);
      return ret;
    }
    ArrayList<Integer> res = new ArrayList<>();
    for (Node child : node.children) {
      res = nodeToRootPath(child, data);
      if (res.size() != 0) {
        res.add(node.data);
        return res;
      }
    }
    return res;
  }
}

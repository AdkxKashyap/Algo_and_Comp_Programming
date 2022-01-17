package Main.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//traverse in zig zag order
public class LevelOrder3 {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();

    public Node() {
      int data = 0;
    }

    public Node(int data) {
      this.data = data;
    }
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

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static void levelOrderLinewiseZZ(Node node) {
    // write your code here
    Stack<Node> mainS = new Stack<>();
    Stack<Node> childS = new Stack<>();
    mainS.push(node);
    int lvl = 1;

    while (mainS.size() != 0) {
      int size = mainS.size();
      while (size-- > 0) {
        Node n = mainS.pop();
        System.out.print(n.data + " ");
        if (lvl % 2 == 1) {
          for (Node child : n.children)
            childS.push(child);
        } else if (lvl % 2 == 0) {
          for (int i = n.children.size() - 1; i >= 0; i--) {
            childS.push(n.children.get(i));
          }
        }
      }
      // swap mainS and childS
      Stack<Node> tmp = new Stack<>();
      tmp = mainS;
      mainS = childS;
      childS = tmp;
      System.out.println();
      lvl++;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    levelOrderLinewiseZZ(root);
  }

}

package Tree;
import java.io.*;
import java.util.*;
public class Diameter {
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
  public static int diameter = 0;
  public static int diameter(Node node){
    int maxht = -1;
    int secondMaxht = -1;

    for(Node child : node.children){
      int ht = diameter(child);
      if(ht > maxht)maxht = ht;
      else secondMaxht = ht;
    }
    diameter = Math.max(diameter, maxht + secondMaxht +2);
    return maxht + 1;
  }
  
 

}

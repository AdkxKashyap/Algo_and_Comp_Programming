package Tree;

import java.util.*;

public class RemoveLeaves {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();

    public Node(){
      int data = 0;
    }

    public Node(int data){
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
  public static void removeLeaves(Node node) {
    // write your code here
    //loop from back so that remove becomes O(1) in best case
    for(int i = node.children.size()-1; i >= 0; i--){
        Node child = node.children.get(i);
        if(child.children.size() == 0){
            node.children.remove(i);
        }
        else{
            removeLeaves(child);
        }
    }
  }
}

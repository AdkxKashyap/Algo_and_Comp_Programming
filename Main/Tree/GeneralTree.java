package Main.Tree;

import java.util.*;

//construct,display,max elem,max height,traversal
public class GeneralTree {
  class Node {
    int data;
    ArrayList<Node> children;

    public Node() {
      this.data = 0;
      children = new ArrayList<>();
    }

    public Node(int data) {
      this.data = data;
      children = new ArrayList<>();
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = null;
    Stack<Node> stk = new Stack<>();

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != null) {
        Node nn = new Node(arr[i]);
        if (root == null) {
          root.children.add(nn);
          stk.push(nn);
        }
      }

    }
  }

  public static void display(){

  }

  public static int size(Node node){
    // write your code here
    int sz=0;
    for(Node child:node.children){
        sz+=size(child);
    }
    return sz+1;
  }

  public static int max(Node node) {
    // write your code here
    int max = Integer.MIN_VALUE;
    for(Node child:node.children){
        max = Math.max(max , max(child));
    }
    return Math.max(max , node.data);
  }

  public static int height(Node node) {
    // write your code here
    int h = -1;
    for(Node child : node.children){
        h = Math.max(h , height(child));
    }
    return h+1;
    
  }

  public static void traversals(Node node){
    System.out.println("Node Pre " + node.data);

    for(Node child: node.children){
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    System.out.println("Node Post " + node.data);
  }
}

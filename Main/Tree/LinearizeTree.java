package Main.Tree;

import java.io.*;
import java.util.*;

public class LinearizeTree {
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
  public static Node getTail(Node node){
    Node tail = node;
    while(tail.children.size() != 0){
      tail = tail.children.get(0);
    }
    return tail;
  }
  public static void linearize(Node node){
    // write your code here
    for(Node child : node.children){
      linearize(child);
    }
    for(int i = node.children.size()-2; i >= 0; i--){
      Node lastnode = node.children.get(i+1); //last children
      Node secLastnode = node.children.get(i);/**Second last node.We need to connect the tail of second last node to last node */
      node.children.remove(lastnode);
      Node tail = getTail(secLastnode);
      tail.children.add(lastnode);
    }
  }
}

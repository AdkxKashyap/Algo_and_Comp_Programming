package Main.Tree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
//print level wise
public class LevelOrder2 {
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

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }
  //using double queues
  public static void levelOrder1(Node node) {
    // write your code here
    Queue<Node> qMain = new ArrayDeque<>();
    Queue<Node> qChild = new ArrayDeque<>();
    qMain.add(node);
    while (qMain.size() != 0) {
      Node n = qMain.remove();
      System.out.print(n.data + " ");
      
      for (Node child : n.children) {
        qChild.add(child);
      }
      if(qMain.size() == 0){
        Queue<Node> tmp = qMain;
        qMain = qChild;
        qChild = tmp;
        System.out.println();
      }
    }
  }

  public static void levelOrder2(Node node) {
    // write your code here
    //Linked list queue allow null
    Queue<Node> qMain = new LinkedList<>();
    
    qMain.add(node);
    qMain.add(null);
    while (qMain.size() != 0) {
      Node n = qMain.remove();
      if(n == null){
        System.out.println();
        if(qMain.size() > 0)qMain.add(null);
        
        continue;
      }
      System.out.print(n.data + " ");
      
      for (Node child : n.children) {
        qMain.add(child);
      }
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
    levelOrder2(root);
  }
}

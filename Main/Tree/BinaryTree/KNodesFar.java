package Main.Tree.BinaryTree;
import java.util.*;

public class KNodesFar {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  public static ArrayList<Node> nodeToRoot(Node node, int data){
    if(node == null)return new ArrayList<>();
    if(node.data == data){
      ArrayList<Node> toRet = new ArrayList<>();
      toRet.add(node);
      return toRet;
    }
    ArrayList lres = nodeToRoot(node.left, data);
    if(lres.size() > 0){
        lres.add(node);
        return lres;
    }
    ArrayList rres = nodeToRoot(node.right, data);
   if(rres.size() > 0){
        rres.add(node);
        return rres;
    }
    
    return new ArrayList<>();
  }
  public static void printKNodesDown(Node node, Node blockage, int k){
    if(node == null || node == blockage || k<0)return;
    if(k == 0){
      System.out.println(node.data);
      return;
    }
    printKNodesDown(node.left, blockage, k-1);
    printKNodesDown(node.right, blockage, k-1);
  }
  public static void printKNodesFar(Node node, int data, int k) {
    // write your code here
    Node blockage = null;
    ArrayList<Node> pathRoot2Node = nodeToRoot(node, data);
    for(int i = 0; i < pathRoot2Node.size() && k >= 0; i++){
      Node n = pathRoot2Node.get(i);
      printKNodesDown(node, blockage, k);
      blockage = n;
      k = k-1;
    } 
  }
}

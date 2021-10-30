package Tree.BinaryTree;

import java.io.*;
import java.util.*;

public class LargestBST {
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
  /**This is O(N) approach.By creating a seperate class we can store the max min size isBST while traversing  */
  public static class BSTPair {
    int size;
    int max;
    int min;
    boolean isBST;

    public BSTPair(){
      this.size = 0;
      this.max = Integer.MIN_VALUE;
      this.min = Integer.MAX_VALUE;
      this.isBST = true;
    }
  }

  public static int sz = 0;
  public static Node maxNode ; 
  public static BSTPair largestBST(Node node){
    if(node  == null) return new BSTPair();

    BSTPair lres = largestBST(node.left);
    BSTPair rres = largestBST(node.right);

    boolean status = node.data > lres.max && node.data < rres.min;
    BSTPair mres = new BSTPair();
    mres.size = lres.size + rres.size + 1;
    mres.max = Math.max(node.data, Math.max(lres.max, rres.max));
    mres.min = Math.min(node.data, Math.max(lres.min, rres.min));
    mres.isBST = lres.isBST && rres.isBST && status;

    if(mres.isBST && mres.size > sz){
      sz = mres.size;
      maxNode = node;
    }

    return mres;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    // write your code here
  }

}

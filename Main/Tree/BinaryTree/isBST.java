package Main.Tree.BinaryTree;
import java.io.*;
import java.util.*;

/**There are two methods is this code O(N^2) 
 * and O(N)
*/

public class isBST {
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

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }
//**Approach 2 - Using BST properties */
  public static int max(Node node) {
    if(node == null) return Integer.MIN_VALUE;
    if(node.left == null && node.right == null)  return node.data;
    return max(node.right);
}
public static int min(Node node) {
    if(node == null) return Integer.MAX_VALUE;
    if(node.left == null && node.right == null) return node.data;
    return min(node.left);
}
public static boolean isBST(Node node) {
 if(node == null) return true;
 int lmax = max(node.left);
 int rmin = min(node.right);
 if(lmax > node.data || rmin < node.data) return false;
 
 boolean lres = isBST(node.left);
 boolean rres = isBST(node.right);
 
 return lres && rres;
}
//**Approach 1 - generic */
  public static int max(Node node){
    if(node == null) return Integer.MIN_VALUE;
    int lmax = max(node.left);
    int rmax = max(node.right);
    return Math.max(node.data, Math.max(lmax, rmax));
  }

  public static int min(Node node){
    if(node == null) return Integer.MAX_VALUE;
    int lmin = min(node.left);
    int rmin = min(node.right);
    return Math.min(node.data, Math.min(lmin, rmin));
  }
  public static boolean isBST(Node node){
        if(node == null) return true;
        int lmax = max(node.left);
        int rmin = min(node.right);
        if(node.data < lmax || node.data > rmin){
            return false;
        }
        boolean lch = isBST(node.left);
        boolean rch = isBST(node.right);

        return lch && rch;
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
    boolean res = isBST(root);
    System.out.println(res);
  }
}

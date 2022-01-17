package Main.Tree.BST;
import java.io.*;
import java.util.*;

//Method 3
public class Main {
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
     public static Node getNextFromLeft(Stack<Pair> stk) {
        while(stk.size() > 0) {
            Pair p = stk.peek();
            Node nn = p.node;
            if(p.state == 0) {
                p.state++;
                if(nn.left != null) {
                    stk.push(new Pair(nn.left, 0));
                }
            }else if(p.state == 1) {
                p.state++;
                if(nn.right != null) stk.push(new Pair(nn.right, 0));
                return nn;
            }else {
                stk.pop();
            }
        }
        return null;
    }
    
    public static Node getNextFromRight(Stack<Pair> stk) {
        while(stk.size() > 0) {
            Pair p = stk.peek();
            Node nn = p.node;
            if(p.state == 0) {
                p.state++;
                if(nn.right != null) {
                    stk.push(new Pair(nn.right, 0));
                }
            }else if(p.state == 1) {
                p.state++;
                if(nn.left != null) stk.push(new Pair(nn.left, 0));
                return nn;
            }else {
                stk.pop();
            }
        }
        return null;
    }
    public static void print(Node node, int target) {
        Stack<Pair> lstk = new Stack<>();
        Stack<Pair> rstk = new Stack<>();
        lstk.push(new Pair(node, 0));
        rstk.push(new Pair(node, 0));
        Node left = getNextFromLeft(lstk);
        Node right = getNextFromRight(rstk);
        
        while(left.data < right.data) {
            if(left.data + right.data < target) {
                left = getNextFromLeft(lstk);
            }
            else if(left.data + right.data > target) {
                right = getNextFromRight(rstk);
            }else {
                System.out.println(left.data + " " + right.data);
                left = getNextFromLeft(lstk);
                right = getNextFromRight(rstk);
            }
        }
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

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    // write your code here
    print(root, data);
  }

}
package Trees;

public class AVLTrees {
  

  private static class Node {
    int data;
    Node left = null;
    Node right = null;
    int balance = 0;
    int height = 0;
    Node(int val) {
      this.data = val;
    }
    Node(int data, Node left, Node right, int balance, int height) {
      this.data = data;
      this.left = left;
      this.right = right;
      this.balance = balance;
      this.height = height;
    }
  }

  public static void updateHeightAndBalanceTree(Node node) {
    int lh = node.left == null ? -1 : node.left.height;
    int rh = node.right == null ? -1 : node.right.height;

    node.balance = lh - rh;
    node.height = 1 + Math.max(lh, rh);
  } 
  //For RR structure
  public static Node leftRotation(Node A) {
    Node ptr = A.right;
    A.right = ptr.left;
    ptr.left = A;

    return ptr;
  }
  //for LL structure
  public static Node rightRotation(Node A) {
    Node ptr = A.left;
    A.left = ptr.right;
    ptr.right = A;

    return ptr;
  }
  public static Node getRotation(Node node) {
    updateHeightAndBalanceTree(node);
    if(node.balance == 2) {
      //LR/LL
      //why we need to chk 0? node.left can also have a right node in that case bf is 0
      if(node.left.balance == 1 || node.left.balance == 0) {
        //LL
        //right rotation
        return rightRotation(node);
      }else if(node.left.balance == -1) {
        //LR
        //1.right rotate
        node.left = leftRotation(node.left);
        return rightRotation(node);
      }
    }else if(node.balance == -2) {
      //RL
      if(node.right.balance == 1) {
        //1.right rotate
        node.right = rightRotation(node.right);
        return leftRotation(node);
      }else if(node.right.balance == -1) {
        return leftRotation(node);
      }
    }
    return node;
  }
  public static Node add(Node root, int val) {
    if(root == null) {
      return new Node(val);
    }
    if(val < root.data) root.left = add(root.left, val);
    else root.right = add(root.right, val);
    //balance
    return getRotation(root);
  }
  public static Node remove(Node node, int data) {
    if(node == null) return null;
    if(node.data < data) node.right = remove(node.right, data);
    else if(data < node.data) node.left = remove(node.left, data);
    else {
      if(node.left == null || node.right == null) {
        return node.left != null ? node.left : node.right;
      }
      Node max = findMax(node.left);
      node.data = max.data;
      node.left = remove(node.left, data);
    }
    return getRotation(node);
  }
  public static Node findMax(Node node) {
    Node ptr = node;
    while(ptr.right != null) {
      ptr = ptr.right;
    }
    return ptr;
  }
  public static void display(Node node) {
    if(node == null) return ;
    String str = "";
    str += node.left != null ? node.left.data + " ": ".";
    str += " <- " +node.data + " -> ";
    str += node.right != null ? node.right.data + " " : ".";
    System.out.println(str);
    display(node.left);
    display(node.right); 
  }
  public static void main(String[] args) {
    Node root = null;
    for(int i = 1; i < 6; i++) {
      root = add(root, i);
    }
    display(root);
    System.out.println("-------------------------------");
    root = remove(root, 5);
    // root= add(root, 2);
    display(root);
  }
}

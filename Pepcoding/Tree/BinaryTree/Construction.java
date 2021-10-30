package Tree.BinaryTree;
import java.util.*;
public class Construction {
  public static class Node{
    int data;
    Node left;
    Node right;

    public Node(){
       data = 0;
    }
    public Node(int data){
      this.data = data;
      left = null;
      right = null;
    }
  }
  public static class Pair{
    Node node;
    int  state;
    Pair(Node node, int state){
      this.node = node;
      this.state = state;
    }
  }
  public static Node construct(Integer[] input){
    Node root = new Node(input[0]);
    Stack<Pair> stk = new Stack<>();
    stk.push(new Pair(root, 0));
    int idx = 0;
    while(stk.size() != 0){
      Pair p = stk.peek();
      
      if(p.state == 0){
        //left child
        idx++;
        if(input[idx] != null){
          Node nn = new Node(input[idx]);
          p.node.left = nn;
          stk.push(new Pair(nn, 0));
        }
        p.state++;
      }
      else if(p.state == 1){
        //right child
        idx++;
        if(input[idx] != null){
        Node nn = new Node(input[idx]);
        p.node.right = nn;
        stk.push(new Pair(nn, 0));
        }
        p.state++;  
      }
      else{
        stk.pop();
      }
      
    }
    return root;
  }

  public static void display(Node root){
    if(root == null)return;
    System.out.println(root.data);
    display(root.left);
    display(root.right);
  }
  public static int size(Node node) {
    // write your code here
    if(node == null) return 0;
    int lsize = size(node.left);
    int rsize = size(node.right);
    return 1 + lsize + rsize;
  }

  public static int sum(Node node) {
    // write your code here
    if(node == null) return 0;
    int lsize = sum(node.left);
    int rsize = sum(node.right);
    return node.data + lsize + rsize;
  }

  public static int max(Node node) {
    // write your code here
    if(node == null) return Integer.MIN_VALUE;
    int lmax= max(node.left);
    int rmax = max(node.right);
    return Math.max(node.data, Math.max(lmax, rmax));
  }

  public static int height(Node node) {
    // write your code here
    if(node == null) return -1;
    int lheight = height(node.left);
    int rheight = height(node.right);
    return Math.max(lheight, rheight) + 1;
  }
  public static void main(String[] args) {
    Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
    Node root = construct(arr);
    display(root);
    int size = size(root);
    System.out.println("Size:"+size);
    int sum = sum(root);
    System.out.println("Sum:"+sum);

    int max = max(root);
    System.out.println("Max:"+max);

    int height = height(root);
    System.out.println("Height:"+height);
  }
}

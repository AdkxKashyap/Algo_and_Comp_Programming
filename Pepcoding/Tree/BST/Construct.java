package Tree.BST;


//Sum, Size, Max, Min, Find
public class Construct {
  public static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public static Node construct(int[] arr, int lo, int hi) {
    if (lo > hi)
      return null;
    int mid = (lo + hi) / 2;
    Node nn = new Node(arr[mid]);
    nn.left = construct(arr, lo, mid - 1);
    nn.right = construct(arr, mid + 1, hi);

    return nn;
  }

  public static void display(Node node) {
    // inorder
    if (node == null)
      return;
    display(node.left);
    System.out.print(node.data + " -> ");
    display(node.right);
  }

  public static int size(Node node) {
    if (node == null)
      return 0;

    int lsz = size(node.left);
    int rsz = size(node.right);

    return 1 + rsz + lsz;
  }

  public static int sum(Node node) {
    if (node == null)
      return 0;

    int lsum = size(node.left);
    int rsum = size(node.right);

    return node.data + lsum + rsum;
  }

  public static int max(Node node) {
    if (node.right == null)
      return node.data;

    int max = max(node.right);

    return max;
  }

  public static int min(Node node) {
    if (node.left == null)
      return node.data;

    int min = min(node.left);

    return min;
  }

  public static boolean find(Node node, int data) {
    if (node == null)
      return false;

    if (node.data == data)
      return true;
    boolean res = false;
    if (data < node.data)
      res = find(node.left, data);
    else if (data > node.data)
      res = find(node.right, data);

    return res;
  }

  public static void fun() {
    int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 110, 200 };
    Node root = construct(arr, 0, arr.length - 1);
    display(root);
    System.out.print("null");
    System.out.println();
    System.out.println("SIZE->" + size(root));
    System.out.println("MIN->" + min(root));
    System.out.println("MAX->" + max(root));
    System.out.println("FIND->" + find(root, 80));
  }

  public static void main(String[] args) {
    fun();
  }
}

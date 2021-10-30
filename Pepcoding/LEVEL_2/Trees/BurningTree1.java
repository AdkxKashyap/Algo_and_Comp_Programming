import java.util.*;

public class BurningTree1 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  public static ArrayList<TreeNode> nodeToRootPath_(TreeNode node, int data) {
        // write your code here
    if(node == null) return null;
    if(node.val == data) {
        ArrayList<TreeNode> lst = new ArrayList<>();
        lst.add(node);
        return lst;
    }
    ArrayList<TreeNode> leftlst = nodeToRootPath_(node.left, data);
    if(leftlst != null){ 
        leftlst.add(node);
        return leftlst;
    }
    
    ArrayList<TreeNode> rightlst = nodeToRootPath_(node.right, data);
     if(rightlst != null){ 
        rightlst.add(node);
        return rightlst;
    }
    return null;
    }
  public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
    ArrayList<TreeNode> res = nodeToRootPath_(node, data);
    return res != null ? res : new ArrayList<>();
  }
  
    public static void solver(TreeNode node, TreeNode blockedNode, int time, int[] res) {
        if(node == null || node == blockedNode) return;
        res[0] = Math.max(res[0], time);
        solver(node.left, blockedNode, time+1, res);
        solver(node.right, blockedNode, time+1, res);
    }
  public static int burningTree(TreeNode root, int fireNode) {
      //dfs approach
    ArrayList<TreeNode> nodeToRoot = nodeToRootPath(root, fireNode);
    TreeNode blockedNode = null;
    int[] res = new int[1];
    int time = 0;
    for(TreeNode node : nodeToRoot) {
        solver(node, blockedNode, time, res);
        time++;
        blockedNode = node;
    }
    return res[0];
  }

  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    int fireNode = scn.nextInt();

    int ans = burningTree(root, fireNode);
    System.out.println(ans);

  }

  public static void main(String[] args) {
    solve();
  }
}
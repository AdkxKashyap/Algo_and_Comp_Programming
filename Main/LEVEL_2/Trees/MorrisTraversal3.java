package Main.LEVEL_2.Trees;
import java.util.*;
//postorder
public class MorrisTraversal3 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static TreeNode findLeftMost(TreeNode node, TreeNode curr) {
    while(node.left != null && node.left != curr)
      node = node.left;
    
    return node;
  }
  public static ArrayList<Integer> morrisInTraversal(TreeNode Treenode) {
    TreeNode curr = Treenode;
    ArrayList<Integer> lst = new ArrayList<Integer>();
    while(curr != null) {
      //here we will traverse the right tree first.So we need to create a thread from leftmost to root so that we can return to root after right tree is processed.
      TreeNode right = curr.right;
      if(right != null) {
        TreeNode leftMostNode = findLeftMost(right, curr);
        //right tree is yet to be processed
        if(leftMostNode.left == null) {
          lst.add(curr.val);
          leftMostNode.left = curr;
          curr = curr.right;
          //this means right tree is processed 
        }else if(leftMostNode.left == curr) {
          curr = curr.left;
        }
      }else {
        lst.add(curr.val);
        curr = curr.left;
      }
    }
     Collections.reverse(lst);
    return lst;
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

    ArrayList<Integer> ans = morrisInTraversal(root);
    for (Integer i : ans)
      System.out.print(i + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}
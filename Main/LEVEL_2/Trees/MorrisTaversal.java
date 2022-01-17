package Main.LEVEL_2.Trees;
import java.util.*;

public class MorrisTaversal {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static TreeNode findRightMost(TreeNode node, TreeNode curr) {
    while(node.right != null && node.right != curr)
      node = node.right;
    
    return node;
  }
  public static ArrayList<Integer> morrisInTraversal(TreeNode Treenode) {
    TreeNode curr = Treenode;
    ArrayList<Integer> lst = new ArrayList<Integer>();
    while(curr != null) {
      TreeNode left = curr.left;
      if(left != null) {
        TreeNode rightMostNode = findRightMost(left, curr);
        if(rightMostNode.right == null) {
          rightMostNode.right = curr;
          curr = curr.left;
        }else if(rightMostNode.right == curr) {
          lst.add(curr.val);
          curr = curr.right;
        }
      }else {
        lst.add(curr.val);
        curr = curr.right;
      }
    }
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
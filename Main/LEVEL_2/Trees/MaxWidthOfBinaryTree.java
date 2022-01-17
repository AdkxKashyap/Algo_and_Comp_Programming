package Main.LEVEL_2.Trees;

import java.util.*;

public class MaxWidthOfBinaryTree {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
    public static class Pair {
        int idx = 0;
        TreeNode node = null;
        
        Pair(int idx, TreeNode node) {
            this.idx = idx;
            this.node = node;
        }
    }
  public static int widthOfBinaryTree(TreeNode root) {
    int max = 0;
    LinkedList<Pair> que = new LinkedList<>();
    que.add(new Pair(0, root));
    while(que.size() != 0) {
        int size = que.size();
        int lm = que.getFirst().idx;
        int rm = que.getLast().idx;
        while(size-- > 0) {
            Pair rem = que.removeFirst();
            TreeNode node = rem.node;
            int idx = rem.idx;
            if(node.left != null) {
                que.addLast(new Pair(2*idx+1, node.left));
            }
            if(node.right != null) {
                que.addLast(new Pair(2*idx+2, node.right));
            }
            max = Math.max(max, rm-lm+1);
        }
    }
    return max;
  }

  // input_section=================================================

  public static void display(TreeNode node) {
    if (node == null)
      return;

    StringBuilder sb = new StringBuilder();
    sb.append((node.left != null ? node.left.val : "."));
    sb.append(" -> " + node.val + " <- ");
    sb.append((node.right != null ? node.right.val : "."));

    System.out.println(sb.toString());

    display(node.left);
    display(node.right);
  }

  public static int idx = 0;

  private static TreeNode deserialize(String[] arr) {
    if (idx >= arr.length || arr[idx].equals("null")) {
      idx++;
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
    node.left = deserialize(arr);
    node.right = deserialize(arr);

    return node;
  }

  public static TreeNode deserialize(String str) {
    String[] arr = str.split(" ");
    return deserialize(arr);
  }

  public static void solve() {
    String str = scn.nextLine();
    TreeNode root = deserialize(str);

    int ans = widthOfBinaryTree(root);
    System.out.println(ans);
  }

  public static void main(String[] args) {
    solve();
  }
}

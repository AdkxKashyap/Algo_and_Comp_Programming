package Main.LEVEL_2.Trees;
import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int idx = 0;
    public static TreeNode BSThelper(int[] postorder, int lo, int hi) {
      if(idx < 0 || postorder[idx] < lo || postorder[idx] > hi) return null;
      int rootval = postorder[idx--];
      TreeNode root = new TreeNode(rootval);
      root.right = BSThelper(postorder, rootval, hi);
      root.left = BSThelper(postorder, lo, rootval);
      return root;
    }
    public static TreeNode bstFromPostorder(int[] postorder) {
        int lo = Integer.MIN_VALUE;
        int hi = Integer.MAX_VALUE;
        idx = postorder.length-1;
        TreeNode root = BSThelper(postorder, lo, hi);
        return root;
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

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
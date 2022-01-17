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
    public static TreeNode BSThelper(int[] preorder, int lo, int hi) {
      if(idx > preorder.length-1 || preorder[idx] < lo || preorder[idx] > hi) return null;
      int rootval = preorder[idx++];
      TreeNode root = new TreeNode(rootval);
      root.left = BSThelper(preorder, lo, rootval);
      root.right = BSThelper(preorder, rootval, hi);
      return root;

    }
    public static TreeNode bstFromPreorder(int[] preorder) {
        int lo = Integer.MIN_VALUE;
        int hi = Integer.MAX_VALUE;
        TreeNode root = BSThelper(preorder, 0, lo, hi);
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

        TreeNode root = bstFromPreorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
package LEVEL_2.Trees;

import java.util.Scanner;

public class Construct3 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static TreeNode construct(int[] pre, int[] post, int preSt, int preEnd, int posSt, int posEnd ) {
      //***why we need both equals and this base case - dry run for {1,2}, {2, 1}.Also pre order and post can give two diff trees.but this algo gives unique res.dry run - [1,2,3] [3,2,1]
      if(preSt > preEnd) return null;
      int rootVal = pre[preSt];
      
      TreeNode root  = new TreeNode(rootVal);
         if(preSt == preEnd) return root;
      int indx = posSt;
      //for preorder left subtree starts just after root.find start left subtree in postorder to know no. of elem in left subtree.if only single node return root(base case).
      while(post[indx] != pre[preSt + 1]) {
        indx++;
      }
      int elemCount = (indx - posSt) + 1;
      root.left = construct(pre, post, preSt + 1, preSt + elemCount, posSt, indx);
      root.right = construct(pre, post, preSt + elemCount + 1, preEnd, indx + 1, posEnd - 1);

      return root;
    }
    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode res = construct(pre, post, 0, pre.length-1, 0, post.length - 1);
        return res;  
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
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = constructFromPrePost(pre, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}

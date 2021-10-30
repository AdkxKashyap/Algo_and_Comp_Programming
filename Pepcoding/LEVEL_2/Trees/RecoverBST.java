package LEVEL_2.Trees;

import java.util.Scanner;
//lc 99
//in lc remove static methods and var.
public class RecoverBST {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

     static TreeNode prev = null;
    //second wrong, should have been in left.
    static TreeNode a = null;
    //this is first wrong,should have been in right subtree
    static TreeNode b = null;
    public static void helper(TreeNode root) {
      if(root == null) return ;
      helper(root.left);
      if(prev == null) prev = root;
      else {
          
         if(prev.val > root.val) {
            if(b == null) {
              //first mistake
              b = prev;
              a = root;
            }else {
              a = root;
            }
        } 
          prev = root;
      }
      helper(root.right);
    }
    public static void recoverTree(TreeNode root) {
        helper(root);
      //swap
      int tmp = a.val;
      a.val = b.val;
      b.val = tmp;
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

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
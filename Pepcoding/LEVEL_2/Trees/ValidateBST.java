package LEVEL_2.Trees;

import java.util.Scanner;

public class ValidateBST {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static TreeNode prev = null;
    public static boolean isValidBST(TreeNode root) {
      if(root == null) return true;
      //check left 
      if(!isValidBST(root.left)) return false;
      //check root
      boolean res = false;
      if(prev == null) {
        res = true;
      }else {
        if(prev.val <= root.val) res = true;
      }
      prev = root;
      //check right
      if(!isValidBST(root.right)) return false;
      return res;
    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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
        System.out.println(isValidBST(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
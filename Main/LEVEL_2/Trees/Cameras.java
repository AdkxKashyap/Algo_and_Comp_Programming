package Main.LEVEL_2.Trees;

import java.util.Scanner;

public class Cameras {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    private static int cameras;
    public static int helper(TreeNode root) {
      /**states -
       * 0 - camera placed
       * 1 - its covered by some other node.
       * 2 - unsafe
       * l - 1, r - 1 -> ret 2
       * if l or r = 2 place cam ret 0 
       */

       //null node does not required any cameras.
      if(root == null) return 1;
      //traverse in postorder.
      int left = helper(root.left);
      int right = helper(root.right);
      if(left == 1 && right == 1) return 2;
      if(left == 2 || right == 2) {
        cameras++;
        return 0;
      }else {
        return 1;
      }
    }
    public static int MinCamerasInBT(TreeNode root) {
      cameras = 0;
        int state = helper(root);
        //for single node
        if(state == 2) cameras++;
        return cameras;
    }

    // input_Section_====================================================================

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
        System.out.println(MinCamerasInBT(root));

    }

    public static void main(String[] args) {
        solve();
    }
}

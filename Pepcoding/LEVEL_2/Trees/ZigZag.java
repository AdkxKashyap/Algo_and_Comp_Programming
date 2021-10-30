package Trees;

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
    static class Pair {
      int forward = -1;//left traversal
      int backward = -1;
      int gmax = 0;
    }
    public static Pair findLongest(TreeNode root) {
      if(root == null) {
        return new Pair();
      }
      Pair fwd = findLongest(root.left);
      Pair bck = findLongest(root.right);
      
      Pair res = new Pair();
      //if we take root.
      res.forward = fwd.backward + 1;
      res.backward = bck.forward + 1;
      //max can also be wo root.this is the global max.
      int max = Math.max(Math.max(fwd.gmax, bck.gmax), Math.max(res.forward, res.backward));
      res.gmax = max;

      return res;
    }
    public static int longestZigZagPath(TreeNode root) {
        Pair res = findLongest(root); 
        return res.gmax;
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

        System.out.println(longestZigZagPath(root));
    }

    public static void main(String[] args) {
        solve();
    }
}

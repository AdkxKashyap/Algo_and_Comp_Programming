package LEVEL_2.Trees;

import java.util.*;

public class ShadowWidth {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    //counter[lh, rh]
    public static void find(TreeNode root, int count, int[] counter) {
        if(root == null) return;
        if(count < counter[0]) counter[0] = count;
        else if(count > counter[1]) counter[1] = count;
        
        find(root.left, count - 1, counter);
        find(root.right, count + 1, counter);
    }
    public static int width(TreeNode root) {
         //counter[lh, rh], avoid taking static vars.
        int[] cntr = new int[2];
        find(root, 0, cntr);
        return cntr[1] - cntr[0] + 1;
    }

    // input_section=================================================

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

        System.out.println(width(root));
    }

    public static void main(String[] args) {
        solve();
    }
}

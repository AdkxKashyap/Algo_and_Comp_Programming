package Trees;

import java.util.*;

public class DiagonalSum {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<>();
    if(root == null) return res;
    Queue<TreeNode> que = new LinkedList<>();
    que.add(root);
    while(que.size() > 0) {
        int factorsize = que.size();
        // ArrayList<Integer> tmp = new ArrayList<>();
        int sum = 0;
        while(factorsize-- > 0) {
            TreeNode rem = que.remove();
            TreeNode ptr = rem;
            while(ptr != null) {
                sum += ptr.val;
                if(ptr.left != null) que.add(ptr.left);
                ptr = ptr.right;
            }
        }
        res.add(sum);
    }
    return res;
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

    ArrayList<Integer> ans = diagonalOrderSum(root);
    for (Integer j : ans)
      System.out.print(j + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}



import java.util.*;

public class PathSum2 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

   public static void helper(TreeNode root, int ssf, ArrayList<Integer> psf, ArrayList<ArrayList<Integer>> res,int tar) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(ssf + root.val == tar) {
                //why we need a dup list? check shallow copy vs deep copy
                ArrayList<Integer> dup = new ArrayList<>();
                for(int val : psf) dup.add(val);
                 dup.add(root.val);
                 res.add(dup);
            } 
            return;
        }
        psf.add(root.val);
        helper(root.left, ssf+root.val,psf, res, tar);
        helper(root.right, ssf+root.val,psf, res, tar);
        psf.remove(psf.size()-1);
    }
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> psf = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        helper(root, 0, psf, res, targetSum);
        return res;
    }

  // input_Section=================================================

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
    int tar = scn.nextInt();
    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    ArrayList<ArrayList<Integer>> ans = pathSum(root, tar);
    if (ans.size() == 0) System.out.println(" ");
    for (ArrayList<Integer> ar : ans) {
      for (Integer ele : ar) {
        System.out.print(ele + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}
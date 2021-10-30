import java.util.Scanner;

public class MaxPathSumBetLeaves {
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
      int LTLMaxPath;
      int NTLMaxPath;
      Pair() {
          this.LTLMaxPath = Integer.MIN_VALUE;
          this.NTLMaxPath = Integer.MIN_VALUE;
      }
      Pair(int ltl, int ntl) {
          this.LTLMaxPath = ltl;
          this.NTLMaxPath = ntl;
      }
  }
    public static Pair maxPathSum_(TreeNode root) {
        Pair ans = new Pair();
        //maybe has left or a right child
        if(root == null) return ans;
        if(root.left == null && root.right == null) {
            //leaf
            ans.NTLMaxPath = root.val;
            return ans;
        }
        Pair lp = maxPathSum_(root.left);
        Pair rp = maxPathSum_(root.right);
        //not incl root
        ans.LTLMaxPath = Math.max(lp.LTLMaxPath, rp.LTLMaxPath);
        //if left right not null only than we can have a max LTL sum incl the root node
        if(root.left != null && root.right != null) {
            ans.LTLMaxPath = Math.max(ans.LTLMaxPath, lp.NTLMaxPath + root.val + rp.NTLMaxPath);
        }
        //max node to root path
        ans.NTLMaxPath = Math.max(lp.NTLMaxPath, rp.NTLMaxPath) + root.val;
        return ans;
    }
  public static int maxPathSum(TreeNode root) {
    Pair res = maxPathSum_(root);
    return res.LTLMaxPath;
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

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    System.out.println(maxPathSum(root));
  }

  public static void main(String[] args) {
    solve();
  }
}
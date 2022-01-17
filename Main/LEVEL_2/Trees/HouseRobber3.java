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
    public class RPair {
      int yesRob;
      int noRob;
      RPair(int x, int y) {
        this.yesRob = x;
        this.noRob = y;
      }
    }
    
    public static RPair getMax(TreeNode root) {
      if(root == null) return new RPair(0, 0);

      RPair c1 = getMax(root.left);
      RPair c2 = getMax(root.right);
      //** a - rob child1, b - not rob child1, a_ - rob child2, b_ - not rob child2 */
      int a = c1.yesRob;
      int b = c1.noRob;
      int a_ = c2.yesRob;
      int b_ = c2.noRob;
      int val = root.val;
      //if I rob curr node, profit
      int yrob = val + b + b_;
      //do not rob.Dont take curr val Max(prev childern yrob, nrob)
      int nrob = Math.max(a,b) + Math.max(a_, b_);
        return new RPair(yrob, nrob);
    }
    public static int HouseRobber(TreeNode root) {
      RPair res= getMax(root);
      return Math.max(res.yesRob, res.noRob);
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
        System.out.println(HouseRobber(root));
    }

    public static void main(String[] args) {
        solve();
    }
}

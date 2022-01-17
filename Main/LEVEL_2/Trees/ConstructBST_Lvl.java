package Main.LEVEL_2.Trees;

import java.util.*;

public class ConstructBST_Lvl {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static class Pair {
      TreeNode par ;
      int low;
      int hi;
      Pair() {
        par = null;
         low = -(int)1e9;
         hi = (int)1e9;
      }
      Pair(TreeNode par, int low, int hi) {
        this.par = par;
        this.low = low;
        this.hi = hi;
      }
    }
    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder) {
      Queue<Pair> que = new LinkedList<>();
      TreeNode root = null;
      int n = LevelOrder.length;
      int i = 0;
      que.add(new Pair());
      while(que.size() != 0 && i < n) {
        Pair rp = que.poll();
        TreeNode parent = rp.par;
        int lo = rp.low;
        int hi = rp.hi;
        int ele = LevelOrder[i];
        if(ele < lo || ele > hi) continue;
        //else correct pos
        TreeNode nn = new TreeNode(ele);
        i++;
        //find left or right of parent
        if(parent == null) root = nn;
        else {
          if(ele < parent.val) parent.left = nn;
          //equal elem in right subtree
          else parent.right = nn;
        }
        //set limits for next left/right nodes.
        que.add(new Pair(nn, lo, ele));
        que.add(new Pair(nn, ele, hi));
      }
        return root;
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
        int[] level = new int[n];
        for (int i = 0; i < n; i++)
            level[i] = scn.nextInt();

        TreeNode root = constructBSTFromLevelOrder(level);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

import BurningTree1.TreeNode;

class UniqueBST2 {
  public List<TreeNode> generateTrees(int n) {
      return helper(1, n);
  }
  public static List<TreeNode> helper(int st, int end) {
    if(st > end) return null;
    List<TreeNode> ans = new ArrayList<>();
    for(int i = st; i <= end; i++) {
      //i is root node. We need to vist all root nodes till end
      //get left possible trees, we need only roots of all possible trees
      List<TreeNode> lres = helper(st, i-1);
      //get right possible trees
      List<TreeNode> rres = helper(i+1, end);

      for(TreeNode ltree : lres) {
        for(TreeNode rtree : rres) {
          TreeNode root = new TreeNode(i);
          root.left = ltree;
          root.right = rtree;
          ans.add(root);
        }
      }
      return ans;
    }
  }
}
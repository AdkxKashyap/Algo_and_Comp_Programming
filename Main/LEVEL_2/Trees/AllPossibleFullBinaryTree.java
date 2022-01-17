package Main.LEVEL_2.Trees;
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
//similar to unique BST2
//do this using dp
class Solution {
  public List<TreeNode> allPossibleFBT(int n) {
      List<TreeNode> res = helper(n);
      return res;
  }
  public static List<TreeNode> helper(int n) {
      List<TreeNode> res = new ArrayList<>();
      if(n == 1) {
          TreeNode nn = new TreeNode(0);
          res.add(nn);
          return res;
      }
      //started from 0. If n == 7, i = 1 means 1 sub tree in left and 5 in right. even nodes cannot make full binary tree.
      for(int i = 1; i < n; i+=2) {
          List<TreeNode> lres = helper(i);
          List<TreeNode> rres = helper(n-i-1);
          for(TreeNode ll : lres) {
              for(TreeNode rr : rres) {
                  TreeNode root = new TreeNode(0);
                  root.left = ll;
                  root.right = rr;
                  res.add(root);
              }
          }
      }
      return res;
  }
}
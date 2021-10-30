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
class Solution {
  int gmax = Integer.MIN_VALUE;
 public  int helper(TreeNode root) {
     if(root == null) return (int)-1e9;
   int lsum = helper(root.left);
   int rsum = helper(root.right);
   
   int toRet = Math.max(root.val, Math.max(root.val + lsum, root.val + rsum));
   gmax = Math.max(gmax, Math.max(toRet, root.val + lsum + rsum));
 return toRet;
 }
 public int maxPathSum(TreeNode root) {
     helper(root);
   return gmax;
 }
}
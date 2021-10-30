package LEVEL_2.Trees;

//lc 105 - Construct Binary Tree from Preorder and Inorder Traversal
class Solution {

  public class TreeNode {
    int val;
    TreeNode left;
   TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
   TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
  }
  public TreeNode constructTree(int[] pre, int[] in, int preSt, int preEnd, int inSt, int inEnd) {
      if(preSt > preEnd) return null;
      TreeNode root = new TreeNode(pre[preSt]);
      
      //find root in inorder
      int indx = inSt;
      while(pre[preSt] != in[indx]) {
          indx++;
      }
      //count elem in left tree in pre
      int elemCount = indx - inSt;
      
      root.left = constructTree(pre, in, preSt + 1, preSt + elemCount, inSt, indx - 1);
      root.right = constructTree(pre, in, preSt + elemCount + 1, preEnd, indx + 1, inEnd);
      
      return root;
  }
  public TreeNode buildTree(int[] preorder, int[] inorder) {
      if(preorder.length == 0) return null;
      TreeNode root = constructTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1 );
      return root;
  }
}

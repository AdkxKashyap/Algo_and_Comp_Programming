package Main.LEVEL_2.Trees;


 //lc - 106 Construct Binary Tree from Inorder and Postorder Traversal
 
class Construct1 {
 // Definition for a binary tree node.
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
  public TreeNode constructTree(int[] in, int[] pos, int inSt, int inEnd, int posSt, int posEnd) {
      if(posSt > posEnd) return null;
      int val = pos[posEnd];
      TreeNode root = new TreeNode(val);
      int indx = inSt;
      while(val != in[indx]) {
          indx++;
      }
      int elemCount = indx - inSt;
      root.left = constructTree(in, pos, inSt, indx-1, posSt, posSt + elemCount-1);//elem-1 bcoz count includes start elem in inodr pre we excl start elem.
      root.right = constructTree(in, pos, indx + 1, inEnd, posSt + elemCount, posEnd - 1);
      
      return root;
  }
  public TreeNode buildTree(int[] inorder, int[] postorder) {
      if(inorder.length == 0) return null;
      TreeNode res = constructTree( inorder, postorder, 0 , inorder.length-1, 0, postorder.length-1);
      return res;
  }
}

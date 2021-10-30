package LEVEL_2.Trees;
import java.util.*;
//duplicates not allowed
public class Construct4 {
  public static Scanner scn = new Scanner(System.in);

  static class TreeNode {
    int val;
    TreeNode left = null, right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  public static TreeNode construct(int[] in, int inSt, int inEnd, ArrayList<Integer> level) {
    int rootVal = level.get(0);
    TreeNode root = new TreeNode(rootVal);
    int indx = inSt;
    Set<Integer> set = new HashSet<>();
    while(in[indx] != rootVal) {
      indx++;
      set.add(in[indx]);
    }
    //why cant we take arr
    ArrayList<Integer> llvl = new ArrayList<>();
    ArrayList<Integer> rlvl = new ArrayList<>();
    for(int i = 1; i < level.size(); i++) {
      int val = level.get(i);
      if(set.contains(val)) {
        llvl.add(val);
      }else {
        rlvl.add(val);
      }
    }
    int elemCount = indx - inSt + 1;
    root.left = construct(in, inSt, inSt + elemCount -1 , llvl);
    root.right = construct(in, inSt + elemCount, inEnd - 1, rlvl);
  }
  public static TreeNode buildTree(int[] inorder, int[] levelOrder) {
    ArrayList<Integer> level = new ArrayList<>();
    for(int i : levelOrder) level.add(i);
    return construct(inorder, 0, inorder.length, level);
  }
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

  int[] InOrder = new int[n];
  for (int i = 0; i < n; i++)
    InOrder[i] = scn.nextInt();

  int[] LevelOrder = new int[n];
  for (int i = 0; i < n; i++)
    LevelOrder[i] = scn.nextInt();

  TreeNode root = buildTree(InOrder, LevelOrder);
  display(root);
}

public static void main(String[] args) {
  solve();
}

}
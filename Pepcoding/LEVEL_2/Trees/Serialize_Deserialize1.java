package LEVEL_2.Trees;

import java.util.*;

public class Serialize_Deserialize1 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
  /** Tree -> String
   * eg - 50#12#null#null#60
   */
  public static void se_helper(TreeNode root, StringBuilder sb) {
    if(root == null) {
      sb.append("null#");
      return;
    }
    sb.append(root.val + "#");
    se_helper(root.left, sb);
    se_helper(root.right, sb);
  } 
  public static String serialize(TreeNode root) {
    StringBuilder sb  = new StringBuilder();
    if(root == null)  {
      return "null#";
    }
    se_helper(root, sb);
    return sb.toString();
  }

    // Decodes your encoded data to tree.
    public static class Pair {
      TreeNode node;
      int state = 0;
      Pair(TreeNode node, int state) {
        this.node = node;
        this.state = state;
      }
    }
    public static TreeNode deserialize(String str) {
      if(str.equals("null#")) return null;
      String[] data = str.split("#");
      Stack<Pair> stk = new Stack<>();
      TreeNode root = new TreeNode(Integer.parseInt(data[0]));
      stk.push(new Pair(root, 0));
      int idx = 1;
      while(idx < data.length) {
        if(stk.peek().state == 2) {
          stk.pop();
        //   idx++;
          continue;
        }
        if(data[idx].equals("null")) {
            stk.peek().state++;
            idx++;
            continue;
        }
        Pair p = stk.peek();
        int val = Integer.parseInt(data[idx]);
        TreeNode nn = new TreeNode(val);
        TreeNode par = p.node;
        if(p.state == 0) {
          //left child
          p.state++;
          par.left = nn;
          stk.push(new Pair(nn, 0));
        }else if(p.state == 1) {
            p.state++;
            par.right = nn;
            stk.push(new Pair(nn, 0));
        }
        idx++;
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

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}

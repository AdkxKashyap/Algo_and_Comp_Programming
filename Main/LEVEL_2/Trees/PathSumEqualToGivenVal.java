package Main.LEVEL_2.Trees;
import java.util.*;

public class PathSumEqualToGivenVal {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  
  public  void solver(TreeNode node, int K, int[] count,int ssf, HashMap<Integer, Integer> hm) {
    if(node == null) return;
    ssf += node.val;
     if(hm.containsKey(ssf-K)) count[0] += hm.get(ssf-K);
    if(hm.containsKey(ssf)) hm.put(ssf, hm.get(ssf) + 1);
    else hm.put(ssf, 1);
    
    solver(node.left, K, count, ssf, hm);
    solver(node.right, K, count, ssf, hm);
    hm.put(ssf, hm.get(ssf) - 1);
 }
 
 public int pathSum(TreeNode root, int targetSum) {
     // if(targetSum == 0) return 0;
     int[] count = new int[1];
     HashMap<Integer, Integer> hm = new HashMap<>();
     hm.put(0, 1);
     solver(root, targetSum, count, 0, hm);
     return count[0];
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

  public static int idx = 0;

  private static TreeNode deserialize(String[] arr) {
    if (idx >= arr.length || arr[idx].equals("null")) {
      idx++;
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
    node.left = deserialize(arr);
    node.right = deserialize(arr);

    return node;
  }

  public static TreeNode deserialize(String str) {
    String[] arr = str.split(" ");
    return deserialize(arr);
  }

  public static void solve() {
    String str = scn.nextLine();
    TreeNode root = deserialize(str);
    int tar = scn.nextInt();

    int ans = pathSum(root, tar);
    System.out.println(ans);
  }

  public static void main(String[] args) {
    solve();
  }
}
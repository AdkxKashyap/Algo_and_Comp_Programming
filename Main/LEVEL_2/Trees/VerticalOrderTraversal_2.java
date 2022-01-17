package Main.LEVEL_2.Trees;

import java.util.*;
//using only arrays.
public class VerticalOrderTraversal_2 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;

      TreeNode(int val) {
          this.val = val;
      }
  }
  private class Pair implements Comparable<Pair> {
    TreeNode node = null;
    int count = 0;
    Pair(TreeNode node, int count) {
        this.node = node;
        this.count = count;
    }
    @Override
    public int compareTo(Pair o) {
        return this.node.val - o.node.val;
    }
}

    public static void find(TreeNode root, int count, int[] counter) {
    if(root == null) return;
    if(count < counter[0]) counter[0] = count;
    else if(count > counter[1]) counter[1] = count;

    find(root.left, count - 1, counter);
    find(root.right, count + 1, counter);
}

public static int[] width(TreeNode root) {
     //counter[lh, rh], avoid taking static vars.
    int[] cntr = new int[2];
    find(root, 0, cntr);
    return cntr;
}

public List<List<Integer>> verticalTraversal(TreeNode root) {
    int[] width = width(root);
    int lh = width[0];
    int rh = width[1];
    int wd = rh - lh  + 1;
    List<List<Integer>> res= new ArrayList<>();
    for(int i = 0; i < wd; i++) {
        res.add(new ArrayList<>());
    }
    PriorityQueue<Pair> main = new PriorityQueue<>();
    PriorityQueue<Pair> tmp = new PriorityQueue<>();
    main.add(new Pair(root, Math.abs(lh)));
    while(main.size() > 0) {
        while(main.size() > 0) {
            Pair rem = main.remove();
            TreeNode node = rem.node;
            res.get(rem.count).add(node.val);
            if(node.left != null) {
                tmp.add(new Pair(node.left, rem.count - 1));
            }
            if(node.right != null) {
                tmp.add(new Pair(node.right, rem.count + 1));
            }
           
        }
         PriorityQueue<Pair> t = new PriorityQueue<>();
            t = main;
            main = tmp;
            tmp = t;
    }
    return res;
}

  // input_section=================================================

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

      ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
      int idx = 0;
      for (ArrayList<Integer> i : ans) {
          System.out.print(idx++ + " -> ");
          for (Integer j : i)
              System.out.print(j + " ");
          System.out.println();
      }
  }

  public static void main(String[] args) {
      solve();
  }
}
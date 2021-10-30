package Trees;
//using only arrays, no hashmaps
import java.util.*;

public class VerticalOrderTraversal_1_2 {
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
        TreeNode node = null;
        int count = 0;
        Pair(TreeNode node, int count) {
            this.node = node;
            this.count = count; 
        }
    }
    //**Find Width */
  //counter[lh, rh]
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
/**Width ends */
  public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
      
      Queue<Pair> qu = new LinkedList<>();
      int wd[] = width(root);
      int lh = wd[0];
      int rh = wd[1];
      int width = rh - lh + 1;
      qu.add(new Pair(root, Math.abs(lh)));
      ArrayList<ArrayList<Integer>> res = new ArrayList<>();
      for(int i = 0; i < width; i++) {
        res.add(new ArrayList<>());
      }
      while(qu.size() > 0) {
          Pair rem = qu.remove();
          int cnt = rem.count;
          
          res.get(cnt).add(rem.node.val);
          
          if(rem.node.left != null) {
              qu.add(new Pair(rem.node.left, cnt - 1));
          }
          if(rem.node.right != null) {
              qu.add(new Pair(rem.node.right, cnt + 1));
          }
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

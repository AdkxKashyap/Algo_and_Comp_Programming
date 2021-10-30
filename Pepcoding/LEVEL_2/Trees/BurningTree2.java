import java.util.*;

public class BurningTree2 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static ArrayList<TreeNode> nodeToRootPath_(TreeNode node, int data) {
    // write your code here
if(node == null) return null;
if(node.val == data) {
    ArrayList<TreeNode> lst = new ArrayList<>();
    lst.add(node);
    return lst;
}
ArrayList<TreeNode> leftlst = nodeToRootPath_(node.left, data);
if(leftlst != null){ 
    leftlst.add(node);
    return leftlst;
}

ArrayList<TreeNode> rightlst = nodeToRootPath_(node.right, data);
 if(rightlst != null){ 
    rightlst.add(node);
    return rightlst;
}
return null;
}
public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
ArrayList<TreeNode> res = nodeToRootPath_(node, data);
return res != null ? res : new ArrayList<>();
}

public static void solver(TreeNode node, TreeNode blockedNode, int time, ArrayList<ArrayList<Integer>> res) {
    if(node == null || node == blockedNode) return;
    if(time == res.size()) {
      ArrayList<Integer> mres = new ArrayList<>();
      mres.add(node.val);
      res.add(mres);
    }else {
            res.get(time).add(node.val);
    }
    solver(node.left, blockedNode, time+1, res);
    solver(node.right, blockedNode, time+1, res);
}

  public static ArrayList<ArrayList<Integer>> burningTree(TreeNode root, int data) {
     //dfs approach
     ArrayList<TreeNode> nodeToRoot = nodeToRootPath(root, data);
     TreeNode blockedNode = null;
     ArrayList<ArrayList<Integer>> res = new ArrayList<>();
     int time = 0;
     for(TreeNode node : nodeToRoot) {
         solver(node, blockedNode, time, res);
         time++;
         blockedNode = node;
     }
     return res;
  }

  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    int fireNode = scn.nextInt();

    ArrayList<ArrayList<Integer>> ans = burningTree(root, fireNode);
    if (ans.size() == 0)
      System.out.println();
    for (ArrayList<Integer> ar : ans) {
      for (Integer ele : ar)
        System.out.print(ele + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}

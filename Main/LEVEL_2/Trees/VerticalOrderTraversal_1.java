package Main.LEVEL_2.Trees;

import java.util.*;

//Uses hashmap chec 1.2 for optimized only arrays version
public class VerticalOrderTraversal_1 {
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
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        int lh = 0;
        int rh = 0;
        Queue<Pair> qu = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<>();
        qu.add(new Pair(root, 0));
        while(qu.size() > 0) {
            Pair rem = qu.remove();
            int cnt = rem.count;
            if(hmap.containsKey(cnt)) {
                
                hmap.get(cnt).add(rem.node.val);
            }else {
                ArrayList<Integer> lst = new ArrayList<>();
                lst.add(rem.node.val);
                hmap.put(cnt, lst);
            }
            if(cnt < lh) lh = cnt;
            else if(cnt > rh) rh = cnt;
            if(rem.node.left != null) {
                qu.add(new Pair(rem.node.left, cnt - 1));
            }
            if(rem.node.right != null) {
                qu.add(new Pair(rem.node.right, cnt + 1));
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // int width = rh - lh + 1;
        for(int i = lh; i <= rh; i++) {
            res.add(hmap.get(i));
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

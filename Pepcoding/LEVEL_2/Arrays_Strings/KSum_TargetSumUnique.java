import java.util.*;
//first see 2sum, 3sum, 4sum
public class KSum_TargetSumUnique {
  public static List<List<Integer>> twoSum(int[] nums, int targ, int k, int st) {
    int left = st;
    int right = nums.length-1;
    List<List<Integer>> res = new ArrayList<>();
    while(left < right) {
      if(left != st && nums[st] == nums[st-1]) {
        left++;
        continue;
      }
      int sum = nums[left] + nums[right];
      if(sum == targ) {
        List<Integer> lst = new ArrayList<>();
        lst.add(nums[left]);
        lst.add(nums[right]);
        res.add(lst);
        left++;
        right--;
      }else if(sum > targ) {
        right--;
      }else {
        left++;
      }
    }
    return res;
  }
  public static List<List<Integer>> solver(int[] nums, int targ, int k, int st) {
    if(k == 2) {
      List<List<Integer>> res = twoSum(nums, targ, k, st);
      return res;
    }
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;
    for(int i = st; i <= n-k; i++) {
      if(i != st && nums[i] == nums[i-1]) continue;
      int val = nums[i];
      List<List<Integer>> lists = solver(nums, targ-val, k-1, i+1);
      for(List<Integer> lst : lists) {
        lst.add(val);
        res.add(lst);
      }
    }
    return res;
  }
  public static List<List<Integer>> kSum(int[] arr, int target, int k) {
    // write your code here
    List<List<Integer>> res = new ArrayList<>();
    if(arr.length < k) return res;
    Arrays.sort(arr);
    if(k == 2) {
      res = twoSum(arr, target, k, 0);
      return res;
  }
    for(int i = 0; i <= arr.length-k; i++) {
      if(i != 0 && arr[i] == arr[i-1]) continue;
      int val = arr[i];
      List<List<Integer>> lists = solver(arr, target-val, k-1, i+1);
      for(List<Integer> lst : lists) {
        lst.add(val);
        res.add(lst);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    int k = scn.nextInt();
    List<List<Integer>> res = kSum(arr, target, k);
    ArrayList<String> finalResult = new ArrayList<>();
    for (List<Integer> list : res) {
      Collections.sort(list);
      String ans = "";
      for (int val : list) {
        ans += val + " ";
      }
      finalResult.add(ans);
    }
    Collections.sort(finalResult);
    for (String str : finalResult) {
      System.out.println(str);
    }
  }

}
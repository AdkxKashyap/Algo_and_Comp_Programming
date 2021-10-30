import java.util.*;

public class FourSum_TargetSumUnique {
    //two_sum
    public static List<List<Integer>> twoSum(int[] arr, int start, int end, int target) {
    // write your code here
    // Arrays.sort(arr);
    List<List<Integer>> res= new ArrayList<>();
    int left = start;
    int right = end;
    while(left < right) {
        if(left != start &&  arr[left] == arr[left-1]) {
        left++;
        continue;
        }
        int sum = arr[left] + arr[right];   
        if(sum == target) {
            List<Integer> lst = new ArrayList<>();
            lst.add(arr[left]);
            lst.add(arr[right]);
            res.add(lst);
            left++;
            right--;
        }else if(sum > target) {
            right--;
        }else {
            left++;
        }
    }
    return res;
  }
  //three_sum
  public static List<List<Integer>> threeSum(int[] nums, int targ, int st) {
    // write your code here
    // Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for(int i = st; i <= nums.length-3; i++) {
        if(i != st && nums[i] == nums[i-1]) continue;
        int val = nums[i];
        List<List<Integer>> twoSum = twoSum(nums, i+1, nums.length-1, targ-val);
        for(List lst : twoSum) {
            lst.add(val);
            res.add(lst);
        }
    }
    return res;
  }
  //4_sum
  public static List<List<Integer>> fourSum(int[] nums, int target) {
    // write your code here
    List<List<Integer>> res = new ArrayList<>();
     Arrays.sort(nums);
     for(int i = 0; i <= nums.length-4; i++) {
         if(i != 0 && nums[i] == nums[i-1]) continue;
         int val = target-nums[i];
         List<List<Integer>> lists = threeSum(nums, val, i+1);
         for(List<Integer> lst : lists) {
             lst.add(nums[i]);
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
    List<List<Integer>> res = fourSum(arr, target);
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
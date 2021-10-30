import java.util.*;

public class MinimumNumOfPlatforms {

  public static int findPlatform(int[] arr, int[] dep) {
    // write your code here
    Arrays.sort(arr);
    Arrays.sort(dep);
    int n = arr.length;
    int i = 0;
    int j = 0;
    int maxtrains = 0;
    int platforms = 0;
    while(i < n && j < n) {
        if(arr[i] > dep[j]) {
            maxtrains--;
            j++;
        }else {
            maxtrains++;
            i++;
        }
        platforms = Math.max(platforms, maxtrains);
    }
    return platforms;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int[] dep = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    for (int i = 0; i < n; i++) {
      dep[i] = scn.nextInt();
    }

    int plateforms = findPlatform(arr, dep);
    System.out.println(plateforms);
  }
}
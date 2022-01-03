import java.util.*;

public class Main {
	
	public static int solution(int[] arr) {
		// write your code here
    //sum -> index found
    HashMap<Integer, Integer> hmap = new HashMap<>();
    int max = 0;
    int sum = 0;
    for(int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if(hmap.containsKey(sum)) {
        max = Math.max(max, i - hmap.get(sum));
      }else {
        hmap.put(sum, i);
      }
    }
		return ;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}

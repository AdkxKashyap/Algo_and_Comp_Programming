import java.util.*;

public class Main {
	
	public static int solution(int[] arr) {
		// write your code here
    //sum -> index found
    HashMap<Integer, Integer> hmap = new HashMap<>();
    int sum = 0;
    int count = 0;
    for(int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if(hmap.containsKey(sum)) {
        count += hmap.get(sum);
        hmap.put(sum, hmap.get(sum));
      }else {
        hmap.put(sum, 1);
      }
    }
		return count;
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

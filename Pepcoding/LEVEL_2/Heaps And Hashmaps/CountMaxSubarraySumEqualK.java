import java.util.*;

public class Main {

	public static int solution(int[] A, int K){
		// write your code here
		
		HashMap<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int count = 0;
    map.put(0, 1);
    int N = A.length;
    for (int i = 0; i < N; i++) {
      sum += A[i];
      if (map.containsKey(sum - K)) {
        //why add with map.get() ? -> see count subaar div K
        count += map.get(sum - K) ;
      } 
      //sum might already be present, in that case dont update idx
        map.put(sum, map.getOrDefault(sum, 0)+1);
    }
    return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
	}

}

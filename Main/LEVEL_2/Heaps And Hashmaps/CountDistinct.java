import java.util.*;

public class Main {

	public static ArrayList<Integer> solution(int[] arr, int k) {
		//write your code here
    HashMap<Integer, Integer> fmap = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();
    //add first k-1 elem in map
    int i = 0;
    for(; i < k-1; i++) {
      fmap.put(arr[i], fmap.getOrDefault(arr[i], 0) + 1);
    }
    //count distinct
    for(int j = 0; i < arr.length;) {
      //add kth elem
      fmap.put(arr[i], fmap.getOrDefault(arr[i], 0)+1);
      //add count 
      list.add(fmap.size());
      //remove jth element
      if(fmap.get(arr[j]) == 1) {
        fmap.remove(arr[j]);
      } else {
        fmap.put(arr[j], fmap.get(arr[j])-1);
      }
      i++;
      j++;
    }
		return list;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}


}

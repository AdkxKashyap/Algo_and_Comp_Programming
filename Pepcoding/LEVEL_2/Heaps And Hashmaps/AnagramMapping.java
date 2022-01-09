import java.util.*;

public class Main {
    class Pair {
      int idx = 0;
      ArrayList<Integer> list = new ArrayList<>();
    }
	public static int[] anagramMappings(int[] arr1, int[] arr2) {
		// write your code here
    HashMap<Integer, Pair> map = new HashMap<>();
    int[] ans = new int[arr1.length]; 
    for(int i = 0; i < arr2.length; i++) {
      int val = arr2[i];
      if(map.containsKey(val)) {
        Pair p = map.get(val);
        p.list.add(i);
        map.put(val, p);
      } else {
        Pair p = new Pair();
        p.list.add(i);
        map.put(val, p);
      }
    }
    for(int i = 0; i < arr1.length; i++) {
      Pair p = map.get(arr1[i]);
      ans[i] = p.list.get(p.idx);
      p.idx++;
    }
		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}

}

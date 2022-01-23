import java.util.*;

public class Main {

    public static void solution(int[] arr) {
        // write your code here
        
       HashMap<Integer, Integer> fmap = new HashMap<>();
    //this hm will store start point of elem
    HashMap<Integer, Integer> smap = new HashMap<>();
    int max = 0;
    int st = 0;
    int end = 0;
    int len = 0;
    for(int i = 0; i < arr.length; i++) {
      if(fmap.containsKey(arr[i])) {
        fmap.put(arr[i], fmap.get(arr[i])+1);
      } else {
        fmap.put(arr[i], 1);
        smap.put(arr[i], i);
      }
      if(fmap.get(arr[i]) > max) {
        max = fmap.get(arr[i]);
        st = smap.get(arr[i]);
        end = i;
        len = end-st+1;

      } else if(fmap.get(arr[i]) > max) {
        int clen = i - smap.get(arr[i]);
        if(clen <= len) {
          max = fmap.get(arr[i]);
          st = smap.get(arr[i]);
          end = i;
          len = end-st+1;
        }
      }
    } 
    System.out.println(arr[st]);
    System.out.println(st);
    System.out.println(end);
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
                solution(arr);
	}

}

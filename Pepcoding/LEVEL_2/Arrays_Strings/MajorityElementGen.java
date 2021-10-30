import java.util.*;

public class MajorityElementGen {
    
    //~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static ArrayList<Integer> majorityElement(int[] arr, int k) {
        // write yout code here
        ArrayList<Integer>res = new ArrayList<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int num = arr.length/k;
        for(int i = 0; i < arr.length; i++) {
          if(hmap.containsKey(arr[i])) {
            hmap.put(arr[i], hmap.get(arr[i])+1);
          }else {
            hmap.put(arr[i], 1);
          }
        }
        for(int i : hmap.keySet()) {
          if(hmap.get(i) > num) res.add(i);
        }
        Collections.sort(res);
        return res;
    }
    
    //~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        ArrayList<Integer> res = majorityElement(arr, k);
        System.out.println(res);
    }
}
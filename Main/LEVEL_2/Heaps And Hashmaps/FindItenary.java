import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

		//write your code here
    //potential src
    HashMap<String, Boolean> pots = new HashMap<>();
    for(String src : map.keySet()) {
      String dest = map.get(src);
      //not src
      pots.put(dest, false);
      //if src is not present in pots,add it
      if(pots.containsKey(src) == false) {
        //could be a pot src
        pots.put(src, true);
      }
    }
    String src = "";
    for(String c : pots.keySet()) {
      if(pots.get(c) == true) {
        src = c;
        break;
      }
    }
    //iterate
    while(true) {
      if(map.containsKey(src)) {
        System.out.println(src + " -> ");
        src = map.get(src);
      }else {
        //dest will not be presetn as key in map.Check it
        System.out.println(src + ".");
        break;
      }
    }
	}
}

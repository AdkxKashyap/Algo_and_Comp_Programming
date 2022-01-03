import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here
    //emp -> manager
    HashMap<String, String> map = new HashMap<>();
    for(int i = 0; i < n; i++) {
      map.put(scn.next(), scn.next());
    }
    findSize(map);
  }
  public static void findSize(HashMap<String, String> map) {
    //manager -> set of emps
    HashMap<String, ArrayList<String>> tree = new HashMap<>();
    String ceo = "";
    for(String emp : map.keySet()) {
      String mgr = map.get(emp);
      //CEO
      if(mgr.equals(emp)) {
        ceo = mgr;
        continue;
      };
      if(tree.containsKey(mgr)) {
        ArrayList<String> emps = tree.get(mgr);
        emps.add(emp);
      }else {
        ArrayList<String> emps = new ArrayList<>();
        emps.add(emp);
        tree.put(mgr, emps);
      }
    }
    HashMap<String, Integer> res = new HashMap<>();
    count(tree, ceo, res);
    for(String emp : res.keySet()) {
      System.out.println(emp + " " + res.get(emp));
    }
  } 
  public static int count(HashMap<String, ArrayList<String>> tree, String mgr, HashMap<String, Integer> res ) {
    int sz = 0;
    //when an emp does not have anyone working under them
    if(tree.get(mgr) == null) {
      res.put(mgr, sz);
      return sz+1;
    }
    for(String emp : tree.get(mgr)) {
      int cn = count(tree, emp, res);
      sz += cn;
    }
    res.put(mgr, sz);
    return sz+1;
  }
}
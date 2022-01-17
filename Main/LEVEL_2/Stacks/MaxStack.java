package Main.LEVEL_2.Stacks;
import java.io.*;
import java.util.*;

public class Main {
  public static class MaxStack {
    class Node {
      int val;
      Node prev, next;
      Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
      }
    }
    private final TreeMap<Integer, ArrayList<Node>> tmap ;
    Node head;
    Node tail;
    public MaxStack() {
      tmap = new TreeMap<>();
      //create dummys to avoid edge cases
      head = new Node(-1);
      tail = new Node(-1);
      head.next = tail;
      tail.prev= head;
    }
    public Node addLast(int x){
      Node nn = new Node(x);
      nn.next = tail;
      nn.prev= tail.prev;
      tail.prev.next = nn;
      tail.prev = nn;
      return nn;
    }
    public void remove(Node rem) {
      Node pre = rem.prev;
      Node next = rem.next;
      pre.next = next;
      next.prev = pre;
      rem.next = null;
      rem.prev = null;
    }
    public void push(int x) {
      Node nn = addLast(x);
      ArrayList<Node> list = new ArrayList<>();
      if(tmap.containsKey(x)) {
        list = tmap.get(x);
      } else {
        tmap.put(x, list);
      }
      list.add(nn);
    }

    public int pop() {
      Node rem = tail.prev;
      //remove from stk
      remove(rem);
      //remove from map
      ArrayList<Node> list = tmap.get(rem.val);
      list.remove(list.size()-1);
      if(list.size() == 0) {
        tmap.remove(rem.val);
      }
      return rem.val;
    }

    public int top() {
      return tail.prev.val;
    }

    public int peekMax() {
      int max = tmap.lastKey();
      return max;
    }

    public int popMax() {
      int key = tmap.lastKey();
      ArrayList<Node> list = tmap.get(key);
      Node rem = list.remove(list.size()-1);
      //remove from stack
      remove(rem);
      //if this was the last occurance of rem.val than remove from map
      if(list.size() == 0) {
        tmap.remove(rem.val);
        
      }
      return rem.val;
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    MaxStack maxst = new MaxStack();

    while (read.ready()) {
      String []inp = read.readLine().split(" ");

      switch (inp[0]) {
        case "pop":
          System.out.println(maxst.pop());
          break;
        case "top":
          System.out.println(maxst.top());
          break;
        case "popMax":
          System.out.println(maxst.popMax());
          break;
        case "peekMax":
          System.out.println(maxst.peekMax());
          break;
        case "push":
          maxst.push(Integer.parseInt(inp[1]));
          break;
      }

    }

  }
}

package Main.LinkedList;

public class oddEven {
  public static class Node {
    int data;
    Node next;

    public Node() {
      this.next = null;
    }

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val) {
      Node temp = new Node();
      temp.data = val;
      temp.next = null;

      if (size == 0) {
        head = tail = temp;
      } else {
        tail.next = temp;
        tail = temp;
      }

      size++;
    }

    public int size() {
      return size;
    }

    public void display() {
      for (Node temp = head; temp != null; temp = temp.next) {
        System.out.print(temp.data + " ");
      }
      System.out.println();
    }

    public void oddEven(){
      // write your code here
      Node evenDummy = new Node(-1);
      Node oddDummy = new Node(-1);
      Node e = evenDummy;
      Node o = oddDummy;
      Node itr = this.head;
      
      while(itr != null){
          if(itr.data % 2 == 0){
              e.next = itr;
              e = e.next;
              itr = itr.next;
          }
          else{
              o.next = itr;
              o =o.next;
              itr = itr.next;
          }
      }
      o.next = evenDummy.next;
      e.next = null;
      this.head = oddDummy.next;
      this.tail = evenDummy.next == null?o:e;
    }
  }
}
}

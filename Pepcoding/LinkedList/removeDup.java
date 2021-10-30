package LinkedList;

public class removeDup {
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

    public void removeDuplicates(){
      // write your code here
      if(head == null)return;
      Node tmp = this.head;
      Node itr = this.head.next;
      while(itr != null){
          while(itr != null && itr.data == tmp.data){
              itr = itr.next;
          }
          if(itr != null){
              tmp.next = itr;
              tmp = tmp.next;
              itr = itr.next;
          }
      }
       tmp.next = itr;
    }
  }
}
}

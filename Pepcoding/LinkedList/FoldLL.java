package LinkedList;

public class FoldLL {
  public static class Node {
    int data;
    Node next;
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
    public void addFirst(int val) {
      Node temp = new Node();
      temp.data = val;
      temp.next = head;
      head = temp;

      if (size == 0) {
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

    public Node mid(Node head) {
      Node slow = head;
      Node fast = head.next;

      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      return slow;
    }

    public Node reverse(Node node) {
      Node prev = null;
      Node curr = node;
      while (curr != null) {
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      return prev;
    }

    public void fold() {
      // write your code here
      Node mid = mid(head);
      Node head2 = reverse(mid.next);
      Node head1 = head;
      mid.next = null;

      while (head1 != null && head2 != null) {
        Node nxt1 = head1.next;
        Node nxt2 = head2.next;
        head1.next = head2;
        head2.next = nxt1;
        
        head1 = nxt1;
        head2 = nxt2;
      }
      //to find tail
      Node tmp=head;
      while(tmp.next != null){
        tmp = tmp.next;
      }
      tail = tmp;
    }
    public static void main(String[] args) {
      LinkedList ll=new LinkedList();
      ll.addLast(1);
      ll.addLast(2);
      ll.addLast(3);
      ll.addLast(4);
      ll.addLast(5);
      Node mid=ll.mid(ll.head);
      ll.fold();
      ll.addFirst(10);
      ll.addLast(20);
      Node head=ll.head;
      while(head != null){
        System.out.print(head.data+",");
        head=head.next;
      }
    }
  }
}

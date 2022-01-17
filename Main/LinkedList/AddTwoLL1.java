package Main.LinkedList;
//using interations
public class AddTwoLL1 {
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

    public int size() {
      return size;
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

    public void display() {
      for (Node temp = head; temp != null; temp = temp.next) {
        System.out.print(temp.data + " ");
      }
      System.out.println();
    }

    public static Node reverseLL(Node node) {
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

    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
      // write your code here
      Node head1 = reverseLL(one.head);
      Node head2 = reverseLL(two.head);
      LinkedList resLL = new LinkedList();
   

      Node i = head1;
      Node j = head2;
      int carry = 0;
      while (i != null || j != null || carry != 0) {
        int ival = i == null ? 0 : i.data;
        i = i == null ? null : i.next;

        int jval = j == null ? 0 : j.data;
        j = j == null ? null : j.next;

        int sum = ival + jval + carry;
        int val = sum % 10;
        carry = sum / 10;
        resLL.addFirst(val);
      }
      head1 = reverseLL(one.head);
      head2 = reverseLL(two.head);
      return resLL;
    }
  }
}

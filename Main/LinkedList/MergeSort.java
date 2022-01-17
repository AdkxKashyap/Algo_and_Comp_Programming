package Main.LinkedList;

public class MergeSort {
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
  }

  // Here both the ll are given to us
  public static LinkedList mergeTwoSortedLists1(LinkedList l1, LinkedList l2) {
    // write your code hered
    LinkedList res = new LinkedList();
    Node head1 = l1.head;
    Node head2 = l2.head;
    while (head1 != null && head2 != null) {
      if (head1.data < head2.data) {
        res.addLast(head1.data);
        head1 = head1.next;
      } else {
        res.addLast(head2.data);
        head2 = head2.next;
      }
    }
    while (head1 != null) {
      res.addLast(head1.data);
      head1 = head1.next;
    }
    while (head2 != null) {
      res.addLast(head2.data);
      head2 = head2.next;
    }
    return res;
  }
  public static Node getMid(Node head, Node tail){
    Node slow = head;
    Node fast = head;
    while(fast != tail && fast.next != tail){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  public static LinkedList mergeSort(Node head, Node tail) {
    // write your code here
    if(head == tail){
      LinkedList ll = new LinkedList();
      ll.addLast(head.data);
      return ll;
    }
    
    Node mid = getMid(head, tail);
    LinkedList ll1 = mergeSort(head, mid);
    LinkedList ll2 = mergeSort(mid.next, tail);

    LinkedList resLL = mergeTwoSortedLists1(ll1, ll2);
    return resLL;
  }
}

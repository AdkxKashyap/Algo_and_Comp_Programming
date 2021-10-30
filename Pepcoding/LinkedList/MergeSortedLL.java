package LinkedList;
/** 2 ways
 *  -Both ll would be given to us
 *  - only Heads of both ll will be given to us.
 */
public class MergeSortedLL {
  public static class Node {
    int data;
    Node next;

    public Node(){
      this.next = null; 
    }

    public Node(int data){
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
//Here both the ll are given to us
  public static LinkedList mergeTwoSortedLists1(LinkedList l1, LinkedList l2) {
    // write your code hered
    LinkedList res = new LinkedList();
    Node head1 = l1.head;
    Node head2 = l2.head;
    while(head1 != null && head2 != null){
      if(head1.data < head2.data){
        res.addLast(head1.data);
        head1 = head1.next;
      }
      else{
        res.addLast(head2.data);
        head2 = head2.next;
      }
    }
    while(head1 != null){
      res.addLast(head1.data);
      head1 = head1.next;
    }
    while(head2 != null){
      res.addLast(head2.data);
      head2 = head2.next;
    }
    return res;
  }
  //here let us assume only heads are given to us
  //see leetcode 21 
  public static LinkedList mergeTwoSortedLists2(LinkedList l1, LinkedList l2){
    Node head1 = l1.head;
    Node head2 = l2.head;

    //this node is created just to set the head node of res later
    Node dummy = new Node(-1);
    Node tmp = dummy;
    while(head1 != null && head2 != null){
      if(head1.data < head2.data){
        tmp.next = head1;
        tmp = tmp.next;
        head1 = head1.next;
      }
      else{
        tmp.next = head2;
        tmp = tmp.next;
        head2 = head2.next;
      }
    }
    if(head1 != null){
      tmp.next = head1;
    }else if(head2 != null){
      tmp.next = head2;
    }
    LinkedList res = new LinkedList();
    res.head = dummy.next;
    //finding tail
    Node tp = dummy.next;
    while(tp.next != null){
      tp = tp.next;
    }
    res.tail = tp;
    return res;
  }
}

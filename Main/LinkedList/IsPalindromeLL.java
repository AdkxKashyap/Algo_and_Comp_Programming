package Main.LinkedList;

public class IsPalindromeLL {
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

    public void display() {
      for (Node temp = head; temp != null; temp = temp.next) {
        System.out.print(temp.data + " ");
      }
      System.out.println();
    }

    public Node mid(Node head){
      Node slow = head;
      Node fast = head.next;

      while(fast != null && fast.next != null){
        slow=slow.next;
        fast=fast.next.next;
      }
      return slow;
    }
    public Node reverse(Node node){
      Node prev = null;
      Node curr = node;
      while(curr != null){
        Node next = curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
      }
      return prev;
    }
    public boolean IsPalindrome() {
      // write your code here
      Node mid=mid(head);
      Node head2=reverse(mid.next);
      mid.next=null;
      Node head1=head;
      boolean res=true;

      while(head1 != null && head2 != null){
        if(head1.data != head2.data) {
          res=false;
          break;
        }
        head1=head1.next;
        head2=head2.next;
      }
      head2=reverse(head2);
      mid.next=head2;
      return res;
    }

    public static void main(String[] args) {
      LinkedList ll=new LinkedList();
      ll.addLast(1);
      // ll.addLast(9);
      // // ll.addLast(3);
      // ll.addLast(2);
      // ll.addLast(1);
      Node mid=ll.mid(ll.head);
      System.out.println(ll.IsPalindrome());
    }
  }
}

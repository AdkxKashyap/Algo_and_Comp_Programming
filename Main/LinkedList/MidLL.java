package Main.LinkedList;

/**
 * For odd only there is only 1 mid.But for odd there are two mids.Here we will
 * find mid1(end of 1st half) mid 2(start of second half)
 */
public class MidLL {
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
    public int mid1(){
      if(head==null){System.out.println("Head is null");return -1;};
      // write your code here
      Node ptr1=head;
      Node ptr2=head.next;
      //1st cond for odd size ,2nd for even size
      while(ptr2!=null || ptr2.next!=null){
        ptr1=ptr1.next;
        ptr2=ptr2.next.next;
      }
      return ptr1.data;
    }
    public int mid2(){
      // write your code here
      if(head==null){System.out.println("Head is null");return -1;};
      Node ptr1=head;
      Node ptr2=head;
      //1st cond for even size ,2nd for odd size
      while(ptr2!=null || ptr2.next!=null){
        ptr1=ptr1.next;
        ptr2=ptr2.next.next;
      }
      return ptr1.data;
    }
  }
}

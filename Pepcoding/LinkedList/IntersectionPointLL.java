package LinkedList;

public class IntersectionPointLL {
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

    public static int findIntersection(LinkedList one, LinkedList two) {
      // write your code here
      Node t1 = one.head;
      Node t2 = two.head;
      int s1 = one.size();
      int s2 = two.size();

      if (s1 > s2) {
        int diff = s1 - s2;
        for (int i = 0; i < diff; i++) {
          t1 = t1.next;
        }
      } else if (s1 < s2) {
        int diff = s2 - s1;
        for (int i = 0; i < diff; i++) {
          t2 = t2.next;
        }
      }
      while(t1!=t2 && t1!=null && t2!=null){
        t1=t1.next;
        t2=t2.next;
      }
      return t1.data; 
    }
  }
}

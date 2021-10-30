package LinkedList;
//using reccursions
public class AddTwoLL2 {
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

   public static int helper(Node one, Node  two , int idx1 , int idx2 , LinkedList res){
     if(one == null && two == null){
       return 0;
     }
     int d1=one.data;
     int d2=two.data;
     int sum=0;

     if(idx1 > idx2){
      int carry=helper(one.next, two, idx1-1, idx2, res);
      sum=d1+carry;
     }
     if(idx1 < idx2){
      int carry=helper(one, two.next, idx1, idx2-1, res);
      sum=d2+carry;
    }
    if(idx1 == idx2){
      int carry=helper(one.next, two.next, idx1-1, idx2-1, res);
      sum=d1+d2+carry;
    }
    res.addFirst(sum%10);
    return sum/10;
   }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
      // write your code here
      LinkedList res=new LinkedList();
      int carry=helper(one.head, two.head, one.size(), two.size(), res);
      if(carry>0){
        res.addFirst(carry);
      }
      return res;
    }
  }
}

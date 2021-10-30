package LinkedList;

//each ListNode is pointing to a random pointer
public class CopyLL {
  public static class ListNode {
    int val = 0;
    ListNode next = null;
    ListNode random = null;

    ListNode(int val) {
        this.val = val;
    }
}

public static ListNode copyRandomList(ListNode head) {
  //dummy is created just to create head of the new clone ll.
  ListNode dummy = new ListNode(-1);
  ListNode t1 = dummy;
  ListNode t2 = head;
  //create clone
  while(t2 != null){
    ListNode nn = new ListNode(t2.val);
    t1.next = nn;
    t1 = nn;
    t2 = t2.next;
  }
  //create zigzag
  ListNode head2 = dummy.next;
  ListNode cloneHead = head2;
  t2 = head;
  while(cloneHead != null){
    ListNode nxt1 = t2.next;
    ListNode nxt2 = cloneHead.next;
    t2.next = cloneHead;
    cloneHead.next = nxt1;

    t2 = nxt1;
    cloneHead = nxt2;
  }
  //set random pointer 
  t2 = head;
  while(t2 != null){
    t2.next.random = t2.random == null?null:t2.random.next;
    t2 = t2.next.next;
  }
  //rearrange original list
  ListNode d1 = new ListNode(-1);
  ListNode d2 = new ListNode(-1);
  t1 = d1;
  t2 = d2;
  ListNode tmp = head;
  while(tmp != null){
    t1.next = tmp;
    t2.next = tmp.next;
    
    t1 = t1.next;
    t2 = t2.next;
    tmp = tmp.next.next;
  }
  t1.next = null;
  t2.next = null;
  head = d1.next;
  cloneHead = d2.next;

    return cloneHead;
}

    public static ListNode createClone(ListNode head) {
      LinkedList ll = new LinkedList();
      while (head.next != null) {
        ll.addLast(head.data);
        head = head.next;
      }
      return ll.head;
    }

    public void llZigZag(ListNode cloneHead) {
      ListNode head = this.head;
      while (cloneHead != null) {
        ListNode nxt1 = head.next;
        ListNode nxt2 = cloneHead.next;
        head.next = cloneHead;
        cloneHead.next = nxt1;

        head = nxt1;
        cloneHead = nxt2;
      }
    }

    public  ListNode copyRandomList(ListNode head) {
      ListNode cloneHead = createClone(head);
      llZigZag(cloneHead);
      return null;
    }
  }
}

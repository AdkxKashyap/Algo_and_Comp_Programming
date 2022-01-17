package Main.LEVEL_2.LL_2;

import java.util.*;

class UnfoldLL {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode reverse(ListNode node) {
      if(node == null) return null;
      ListNode curr = node;
      ListNode prev = null;
      while(curr != null) {
        ListNode tmp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = tmp;
      }
      return prev;
    }
    public static void unfold(ListNode head) {
      if(head == null || head.next == null) return ;
      ListNode fhead = head;
      ListNode shead = head.next;
      ListNode fptr = fhead;
      ListNode sptr = shead;
      ListNode fwd = sptr.next;

      while(sptr != null || sptr.next != null) {
        fptr.next = fwd;
        sptr.next = fwd.next;
        //move ptr fwd
        fptr = fwd;
        sptr = sptr.next;
        fwd = sptr.next;
      }
      //for even len.for odd anywas pts to null
      fptr.next = null;
      shead = reverse(shead);
      fptr.next = shead;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}

package Main.LEVEL_2.LL_2;

import java.util.*;

class MergeLL1 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode shead = new ListNode(-1);
        ListNode curr = shead;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        while(ptr1 != null && ptr2 != null) {
          int val1 = l1.val;
          int val2 = l2.val; 
          if(val1 <= val2) {
            curr.next = ptr1;
            
            ptr1 = ptr1.next;
          }else {
            curr.next = ptr2;
            ptr2 = ptr2.next;
          }
          curr = curr.next;
        }
        if(ptr1 != null) curr.next = ptr1;
        else curr.next = ptr2;
        return shead.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        int m = scn.nextInt();
        ListNode h2 = createList(m);


        ListNode head = mergeTwoLists(h1, h2);
        printList(head);
    }
}

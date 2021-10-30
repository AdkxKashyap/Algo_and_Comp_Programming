package LEVEL_2.LL_2;

import java.util.*;
//
class Segregate01_1 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate01(ListNode head) {
        //create dummy
        ListNode dummy_one = new ListNode(-1);
        ListNode dummy_zero = new ListNode(-1);
        ListNode p_one = dummy_one;
        ListNode p_zero = dummy_zero;
        ListNode curr = head;
        
        while(curr != null) {
            if(curr.val == 0) {
                p_zero.next = curr;
                p_zero = p_zero.next;
            }else if(curr.val == 1) {
                p_one.next = curr;
                p_one = p_one.next;
            }
            curr = curr.next;
        }
        p_zero.next = dummy_one.next;
        p_one.next = null;
        return dummy_zero.next;
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
        h1 = segregate01(h1);
        printList(h1);
    }
}

package Main.LEVEL_2.LL_2;
import java.util.*;
//node swap
class Segregate012 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate012(ListNode head) {
        ListNode dummy_one = new ListNode(-1);
        ListNode dummy_two = new ListNode(-1);
        ListNode dummy_zero = new ListNode(-1);
        ListNode p0 = dummy_zero;
        ListNode p1 = dummy_one;
        ListNode p2 = dummy_two;
        ListNode curr = head;
        while(curr != null) {
            if(curr.val == 0) {
                p0.next = curr;
                p0 = p0.next;
            }else if(curr.val == 1) {
                p1.next = curr;
                p1 = p1.next;
            }
            else if(curr.val == 2) {
                p2.next = curr;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        if(dummy_one.next != null) {
            p0.next =  dummy_one.next;
            p1.next = dummy_two.next;
        }else {
            p0.next = dummy_two.next;
        }
        
        p2.next = null;
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
        h1 = segregate012(h1);
        printList(h1);
    }
}
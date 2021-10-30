

import java.util.*;
//swap only data
class Segregate01_2 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate01(ListNode head) {
        ListNode z_seg = head;
        ListNode o_seg = head;
        ListNode curr = head;
        while(o_seg != null) {
            if(o_seg.val == 0) {
                //swap and increment
                int tmp = o_seg.val;
                o_seg.val = z_seg.val;
                z_seg.val = tmp;
                
                o_seg = o_seg.next;
                z_seg = z_seg.next;
            }else {
                o_seg = o_seg.next;
            }
        }
        return head;
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

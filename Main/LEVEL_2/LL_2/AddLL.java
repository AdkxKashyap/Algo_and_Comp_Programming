package Main.LEVEL_2.LL_2;

import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      if(l1 == null || l2 == null) {
        return l1 == null ? l2 : l2 == null ? l1 : null;
      }

      l1 = reverse(l1);
      l2 = reverse(l2);
      ListNode res = new ListNode(-1);
      ListNode rptr = res;
      ListNode i = l1;
      ListNode j = l2;
      int carry = 0;
      while(carry != 0 || i != null || j != null) {
        int val1 = i == null ? 0 : i.val;
        int val2 = j == null ? 0 : j.val;
        i = i == null ? null : i.next;
        j = j == null ? null : j.next;
        int sum  = val1 + val2 + carry;
        int val = sum % 10;
        carry = sum / 10;
        ListNode nn = new ListNode(val);
        rptr.next = nn;
        rptr = rptr.next;
      }
        return reverse(res.next);
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = addTwoNumbers(head1, head2);
        printList(ans);
    }

}

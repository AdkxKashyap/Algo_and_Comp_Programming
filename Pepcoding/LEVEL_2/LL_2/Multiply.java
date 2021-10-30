package LEVEL_2.LL_2;

import java.util.*;


class Multiply {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode node) {
      if(node == null || node.next == null) return node;
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
    public static void addLL(ListNode ans, ListNode prod) {
      ListNode ans_ptr = ans;
      ListNode ptr_prod = prod;
      int carry = 0;
      while(carry != 0 || ptr_prod != null) {
        int val1 = ptr_prod == null ? 0 : ptr_prod.val;
        //since in the additions we start from the next element. 
        int val2 = ans_ptr.next == null ? 0 : ans_ptr.next.val;
        ptr_prod = ptr_prod == null ? null : ptr_prod.next;
        int sum  = val1 + carry + val2;
        int val = sum % 10;
        carry = sum / 10;
        if(ans_ptr.next == null) {
          ans_ptr.next = new ListNode(val);
        }else {
          ans_ptr.next.val = val;
        }
        ans_ptr = ans_ptr.next;
      }
    }
    public static ListNode multiplyWithDigit(ListNode l1, int digit) {
      ListNode ptr = l1;
      ListNode ans = new ListNode(-1);
      ListNode ans_ptr = ans;
      int carry = 0;
      while(ptr != null || carry != 0) {
        int val1 = ptr == null ? 0 : ptr.val;
        int sum = carry + (val1 * digit);
        carry = sum / 10;
        int res = sum % 10;
        ListNode nn = new ListNode(res);
        ans_ptr.next = nn;
        ans_ptr = nn;
        ptr = ptr == null ? null : ptr.next;
      }
      return ans.next;
    }
    
    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
      l1 = reverse(l1);
      l2 = reverse(l2);
      ListNode ptr_l2 = l2;
      ListNode ans = new ListNode(-1);
      ListNode ptr_ans = ans;
      while(ptr_l2 != null) {
        int digit = ptr_l2.val;
        ListNode prod = multiplyWithDigit(l1, digit);
        ptr_l2 = ptr_l2.next;
         addLL(ptr_ans, prod);
        ptr_ans = ptr_ans.next;
      }
        return reverse(ans.next) ;
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

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }
}

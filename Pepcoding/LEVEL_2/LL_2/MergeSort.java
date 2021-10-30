package LEVEL_2.LL_2;

import java.util.*;

import java.util.*;

class MergeSort {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        //we need to find first mid because second mid gives stack overflow err.Dry run 1,2,3,4,5,6,7
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = mid(head);
        ListNode rlist = mid.next;
        mid.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(rlist);
        ListNode res = merge(left, right);
        return res;
    }
    public static ListNode merge(ListNode left, ListNode right) {
        if(left == null || right == null) return left == null ? right : left;
      ListNode res = new ListNode(-1);
      ListNode lptr = left;
      ListNode rptr = right;
      ListNode curr = res;
      while(lptr != null && rptr != null) {
        int lval = lptr.val;
        int rval = rptr.val;
        if(lval <= rval) {
          curr.next = lptr;
          lptr = lptr.next;
        }else {
          curr.next = rptr;
          rptr = rptr.next;
        }
        curr = curr.next;
      }
      if(lptr != null) {
        curr.next = lptr;
      }else if(rptr != null) {
        curr.next = rptr;
      }
      return res.next ;
    }
    
    public static int size(ListNode head) {
      ListNode ptr = head;
      int size = 0;
      while(ptr != null) {
        ptr = ptr.next;
        size++;
      }
      return size;
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

        ListNode head = mergeSort(h1);
        printList(head);
    }
}
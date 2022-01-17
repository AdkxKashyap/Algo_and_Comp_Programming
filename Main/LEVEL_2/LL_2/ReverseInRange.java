package Main.LEVEL_2.LL_2;

import java.util.*;

class ReverseInRange {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    static ListNode thead = null;
    static ListNode tail = null;
    public static void addfirst(ListNode node) {
      if(thead == null) {
        thead = tail = node;
      }else {
        node.next = thead;
        node = thead;
      }
    }
    public static ListNode reverseInRange(ListNode head, int n, int m) {
      if(n < 0 || m > length(head)) return null;
      if(head == null) return null;
      int j = 1;
      ListNode curr = head;
      ListNode pre = null;
      while(j <= m) {
        if(j + 1 == n) {
          pre = curr;
          ListNode tmp = curr.next;
          curr.next = null;
          curr = tmp;
          // pre = tmp;
        }else if(j >= n) {
          ListNode tmp = curr.next;
          curr.next = null;
          addfirst(curr);
          curr = tmp;
        }else {
          curr = curr.next;
        }
        j++;
      }
      if(pre != null) {
       
        pre.next = thead;
        tail.next = curr;
      }else {
        tail.next = curr;
      }
      
      return head;
    }
    public static int length(ListNode head) {
      ListNode ptr = head;
      int len = 0;
      while(ptr != null) {
        len++;
        ptr = ptr.next;
      }
      return len;
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
        int sz = scn.nextInt();
        ListNode h1 = createList(sz);

        int m = scn.nextInt();
        int n = scn.nextInt();

        h1 = reverseInRange(h1, m, n);
        printList(h1);
    }
}

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

  public static ListNode segregate(ListNode head, int pivotIdx) {
      ListNode small = new ListNode(-1);
      ListNode large = new ListNode(-1);
      ListNode sm = small;
      ListNode la = large;
      ListNode pivot = null;
      ListNode curr = head;
      //find pivot data
      for(int i = 0; i < pivotIdx; i++) {
          curr = curr.next;
      }
      pivot = curr;
      curr = head;
      int pval = pivot.val;
      while(curr != null) {
          if(curr == pivot) {
              curr = curr.next;
              continue;
              
          };
          if(curr.val > pval) {
              la.next = curr;
              la = la.next;
          } else {
             sm.next = curr;
             sm = sm.next;
          }
          curr = curr.next;
      }
      sm.next = pivot;
      pivot.next = large.next;
      la.next = null;
      
    return small.next;
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
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}
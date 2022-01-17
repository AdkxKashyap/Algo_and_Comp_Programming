package Main.LEVEL_2.LL_2;
import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//lc - 19
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
       // if(head == null) return null;
      ListNode fast = head;
      ListNode slow = head;
      //move first to nth node
      for(int i = 0; i < n; i++) {
          fast = fast.next;
      }
      //if n == length of list
      if(fast == null) return head.next;
      while(fast.next != null) {
          fast = fast.next;
          slow = slow.next;
      }
      slow.next = slow.next.next;
      return head;
  }
}

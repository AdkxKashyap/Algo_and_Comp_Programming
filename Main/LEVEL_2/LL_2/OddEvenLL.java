package Main.LEVEL_2.LL_2;
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
//lc328
class Solution {
  public ListNode oddEvenList(ListNode head) {
      if(head == null) return null;
      ListNode dodd = new ListNode(-1);
      ListNode deven = new ListNode(-1);
      ListNode odd = head;
      ListNode even = head.next;
      dodd.next = odd;
      deven.next = even;
      while(even != null && even.next != null) {
          odd.next = odd.next.next;
          even.next = even.next.next;
          odd = odd.next;
          even = even.next;
      }
      odd.next = deven.next;
      return dodd.next;
  }
}
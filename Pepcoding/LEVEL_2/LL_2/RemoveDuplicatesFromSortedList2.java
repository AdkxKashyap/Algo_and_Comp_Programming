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
//lc 82
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
      ListNode head2  = new ListNode(-1);
      ListNode curr = head;
      ListNode i = head2;
      //set potentioal next
      i.next = curr;
      while(curr != null) {
          curr = curr.next;
          boolean flag = false;
          while(curr != null && i.next.val == curr.val) {
              flag = true;
              curr = curr.next;
          }
          if(flag) {
              i.next = curr;
          }else {
              i = i.next;
          }
      }
      return head2.next;
  }
}
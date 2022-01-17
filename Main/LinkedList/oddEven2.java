package Main.LinkedList;
//lc - 328

//check odd even index
//check sort colours lc - 75

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
class Solution {
  public ListNode oddEvenList(ListNode head) {
      ListNode even = new ListNode(-1);
      ListNode odd = new ListNode(-1);
      ListNode pe = even;
      ListNode po = odd;
      ListNode curr = head;
      int indx = 1;
      while(curr != null) {
          if(indx % 2 == 0) {
              pe.next = curr;
              pe = pe.next;
          }else {
              po.next = curr;
              po = po.next;
          }
          curr = curr.next;
          indx++;
      }
      pe.next = null;
      po.next = even.next;
      return odd.next;
  }
}
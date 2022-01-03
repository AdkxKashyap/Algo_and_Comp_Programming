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
  ListNode ohead = null;
  ListNode otail = null;
  ListNode th = null;
  ListNode tt = null; 
public void addFirst(ListNode node) {
  if(th == null) {
      th = node;
      tt = node;
  } else {
      node.next = th;
      th = node;
  }
}
public int length(ListNode head) {
  int len = 0;
  ListNode tmp = head;
  while(tmp != null) {
      len++;
      tmp = tmp.next;
  }
  return len;
}
public ListNode reverseKGroup(ListNode head, int k) {
  ListNode curr = head;
  int len = length(head);
  if(len < k) return head;
  while(len >= k) {
      int ktmp = k;
      while(ktmp-- > 0) {
         ListNode fwd = curr.next;
          curr.next = null;
          addFirst(curr);
          curr = fwd;
      }
      if(ohead == null) {
          ohead = th;
          otail = tt;
      } else {
          otail.next = th;
          otail = tt;
      }
      tt = null;
      th = null;
      len-=k;
  }
  otail.next = curr;
  return ohead;
}
}
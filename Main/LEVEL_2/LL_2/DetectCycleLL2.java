package Main.LEVEL_2.LL_2;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//lc 142 - detect start of a cycle
//IMP - see proof in notes
public class Solution {
  public ListNode detectCycle(ListNode head) {
      //detect cycle
      ListNode slow = head;
      ListNode fast = head;
      while(fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
          
          if(slow == fast) break;
      }
      if(fast == null || fast.next == null) return null;
      
      slow = head;
      while(slow != fast) {
          slow = slow.next;
          fast = fast.next;
      }
      return slow;
  }
}
package LL_2;
//floyd cycle detection
//lc 141
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
public class Solution {
  public boolean hasCycle(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      
      while(fast != null && fast.next != null) {
          slow = slow.next;//move x
          fast = fast.next.next;//move 2x
        
          
          if(fast == slow) return true;
          
      }
      return false;
  }
}

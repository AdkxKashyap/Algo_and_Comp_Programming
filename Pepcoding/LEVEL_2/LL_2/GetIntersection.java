//lc - 160
//Find intersection using floyd intersection
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
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      //connect tail 
      ListNode tail = headA;
      while(tail.next != null) {
          tail = tail.next;
      }
      tail.next = headA;
      ListNode res = detectCycle(headB);
      tail.next = null;
      return res;
  }
}
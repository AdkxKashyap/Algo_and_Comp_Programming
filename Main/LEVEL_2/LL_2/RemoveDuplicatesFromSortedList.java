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
//lc 83
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return null;
        ListNode tmp = head;
        ListNode itr = head.next;
        while(itr != null){
            while(itr != null && itr.val == tmp.val){
                itr = itr.next;
            }
            if(itr != null){
                tmp.next = itr;
                tmp = tmp.next;
                itr = itr.next;
            }
        }
         tmp.next = itr;
      return head;
  }
}
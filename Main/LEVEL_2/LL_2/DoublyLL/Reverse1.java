package Main.LEVEL_2.LL_2.DoublyLL;



import java.util.*;

//Reverse Node Of Linkedlist In K Group
class Reverse1 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
   static ListNode ohead = null;
   static ListNode otail = null;
   static ListNode tmpHead = null;
   static ListNode tmpTail = null;
    
    public static void addFirst(ListNode node) {
        if(tmpHead == null) {
            tmpHead = tmpTail = node;
        }else {
            node.next = tmpHead;
            tmpHead = node;
        }
    }
    public static int length(ListNode head) {
        ListNode ptr = head;
        int len = 0;

        while(ptr != null) {
            len++;
            ptr = ptr.next;
        }
        return len;
    }
    public static ListNode reverseInKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int len = length(head);
        ListNode curr = head;
        while(len >= k) {
            int j = k;
            while(j > 0) {
                ListNode fwd = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = fwd;
                j--;
            }
            if(ohead == null) {
                ohead = tmpHead;
                otail = tmpTail;
            }else {
                otail.next = tmpHead;
                otail = tmpTail;
            }
            tmpHead = null;
            tmpHead = null;
            len -= k;
        }
        otail.next = curr;
        return ohead;
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

        int k = scn.nextInt();
        h1 = reverseInKGroup(h1, k);
        printList(h1);
    }
}

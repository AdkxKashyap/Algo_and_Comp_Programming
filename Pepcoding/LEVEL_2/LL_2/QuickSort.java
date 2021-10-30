package LEVEL-2.LL_2;

import java.util.*;
//1 - Check segregation over pivot index
class QuickSort {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode[] segregate(ListNode head, int pivot){
        ListNode pivotNode = head;
        while(pivot-- > 0) {
            pivotNode = pivotNode.next;
        }
        ListNode smaller = new ListNode(-1);
        ListNode larger = new ListNode(-1);
        ListNode sm = smaller;
        ListNode lr = larger;
        ListNode curr = head;
        while(curr != null) {
            if(curr != pivotNode) {
                if(curr.val <= pivotNode.val) {
                sm.next = curr;
                sm = sm.next;
                }else {
                lr.next = curr;
                lr = lr.next;
                }
            }
          
            curr = curr.next;
        }
         //right
            lr.next = null;
            //left
            sm.next = null;
            pivotNode.next = null;
            return new ListNode[]{smaller.next, pivotNode, larger.next};
    }
    public static ListNode[] quickSort(ListNode head) {
        if(head == null || head.next == null) {
            return new ListNode[]{head, head};
        }
        int len = length(head);
        int pivotIndx = len/2;
        ListNode[] segregatedList = segregate(head, pivotIndx);
        //array will have [head, tail]
        ListNode[] leftSorted = quickSort(segregatedList[0]);
        ListNode[] rightSorted = quickSort(segregatedList[2]);
        
        return mergeList(leftSorted, segregatedList[1], rightSorted);
    }
    public static ListNode[] mergeList(ListNode[] leftSorted,ListNode pivot, ListNode[] rightSorted) {
        ListNode head = null;
        ListNode tail = null;
        if(leftSorted[0] != null && rightSorted[0] != null) {
            leftSorted[1].next = pivot;
            pivot.next = rightSorted[0];
            head = leftSorted[0];
            tail = rightSorted[1];
        }else if(leftSorted[0] != null) {
            leftSorted[1].next = pivot;
            pivot.next = null;
            head = leftSorted[0];
            tail = pivot;
        }else if(rightSorted[0] != null) {
            pivot.next = rightSorted[0];
            head = pivot;
            tail = rightSorted[1];
        }
        return new ListNode[]{head, tail};
    }
    public static int length(ListNode head) {
        if(head == null) return 0;
        ListNode ptr = head;
        int len = 0;
        while(ptr != null) {
            len++;
            ptr = ptr.next;
        }
        return len;
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

        ListNode[] head = quickSort(h1);
        printList(head[0]);
    }
}

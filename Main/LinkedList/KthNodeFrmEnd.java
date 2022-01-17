package Main.LinkedList;
import java.util.*;
public class KthNodeFrmEnd {
  private class Node {
    private int data;
    private Node next;

    public Node() {
      this.data = 0;
      this.next = null;
    }

    public Node(int data) {
      this.data = data;
      this.next = null;
    }

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
  
  private Node head;
  private Node tail;
  private int size;

  public void LinkedList() {
    this.head = this.tail = null;
    this.size = 0;
  }

  public void addFirst(int val) {

    if (this.size == 0) {
      handleSizeZero(val);
    } else {
      Node newNode = new Node(val);
      newNode.next = head;
      head = newNode;
      this.size++;
      // System.out.println(newNode.next.data);
    }

  }
  
  public int kthFromLast(int k) {
    // write your code here
    Node fast=this.head;
    Node slow= this.head;
    //moving fast to kth node from first
    for(int i=0;i<k;i++){
      fast=fast.next;
    }

    while(fast.next != null){
      fast=fast.next;
      slow=slow.next;
    }
    return slow.data;
  }
}

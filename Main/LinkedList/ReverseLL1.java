package Main.LinkedList;
//Reverse only data not pointers
public class ReverseLL1 {
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

  public LinkedList() {
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

  public void addLast(int val) {

    if (this.size == 0) {
      handleSizeZero(val);
    } else {
      Node newNode = new Node(val);
      this.tail.next = newNode;
      this.tail = newNode;
      this.size++;
    }

  }

  public void addAt(int val, int index) {
    if (index < 0 || index > this.size) {
      System.out.println("Invalid Position");
      return;
    }
    if (index == 0) {
      addFirst(val);
      return;
    }
    if (index == size) {
      addLast(val);
      return;
    }
    Node node1 = getNthNode(index - 1);
    Node newNode = new Node(val);
    newNode.next = node1.next;
    node1.next = newNode;
    size++;
  }

  public void removeFirst() {
    if (this.size == 0) {
      System.out.println("No Data");
      return;
    }
    if (this.size == 1) {
      removeForSizeZero();
    } else {
      head = head.next;
      size--;
    }
  }

  public void removeLast() {
    if (size == 1) {
      removeForSizeZero();
    }
    Node secondLstElem = getNthNode(this.size - 2);
    secondLstElem.next = null;
    tail = secondLstElem;
    this.size--;
  }

  public void removeAt(int idx) {
    if (idx == 0) {
      removeFirst();
      return;
    }
    if (idx == size - 1) {
      removeLast();
      return;
    }
    Node nToRemove = getNthNode(idx);
    Node prevNode = getNthNode(idx - 1);
    prevNode.next = nToRemove.next;
    nToRemove.next = null;
    size--;
  }
  public void reverseLL(){
    if(size == 0){
      System.out.println("Invalid size");
      return;
    }
    
    if(size>1){
      int left = 0;
      int right = size - 1;
      
      while(left<right){
        Node leftN=getNthNode(left);
        Node rightN=getNthNode(right);
        int tmp=leftN.data;
        leftN.data=rightN.data;
        rightN.data=tmp;
        left++;
        right--;
      }
    }
  }
  public void display() {
    Node tmp = this.head;
    while (tmp != null) {
      System.out.print(tmp.data + "->");
      tmp = tmp.next;
    }
    System.out.print("null");

  }

  private void handleSizeZero(int val) {
    Node newNode = new Node(val);
    this.head = newNode;
    this.tail = newNode;
    this.size++;
  }

  private void removeForSizeZero() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  private Node getNthNode(int pos) {
    Node tmp = this.head;
    while (pos > 0) {
      tmp = tmp.next;
      pos--;
    }
    return tmp;
  }

  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.addFirst(10);
    ll.addFirst(11);
    ll.addLast(20);
    ll.addLast(21);

    ll.addAt(32, 3);
    // ll.display();
    // ll.removeFirst();
    // ll.removeFirst();
    // ll.removeFirst();
    // ll.removeLast();
    ll.removeAt(3);
    ll.display();
  }
}

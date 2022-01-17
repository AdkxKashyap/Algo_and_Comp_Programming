package Main.LEVEL_2.Stacks;
class MyCircularDeque {
  class Node {
    Node next;
    Node prev;
    int val;

    Node(int val) {
      this.val = val;
      next = null;
      prev = null;
    }

    public void delete() {
      this.prev.next = this.next;
      this.next.prev = prev;
    }
  }

  Node front;
  Node rear;
  int k;
  int size;

  public MyCircularDeque(int k) {
    front = new Node(-1);
    rear = new Node(-1);
    front.next = rear;
    rear.prev = front;
    this.k = k;
    size = 0;
  }

  public boolean insertFront(int value) {
    if (isFull())
      return false;
    Node nn = new Node(value);
    nn.prev = front;
    nn.next = front.next;
    front.next.prev = nn;
    front.next = nn;
    size++;
    return true;
  }

  public boolean insertLast(int value) {
    if (isFull())
      return false;
    Node nn = new Node(value);
    rear.prev.next = nn;
    nn.prev = rear.prev;
    nn.next = rear;
    rear.prev = nn;
    size++;
    return true;
  }

  public boolean deleteFront() {
    if (isEmpty())
      return false;
    size--;

    // lengthy method, instead add a delete method
    // Node toDel = front.next;
    // front.next.next.prev = front;
    // front.next = front.next.next;
    // toDel.next = null;
    // toDel.prev = null;
    Node todel = front.next;
    todel.delete();
    return true;
  }

  public boolean deleteLast() {
    if (isEmpty())
      return false;
    Node todel = rear.prev;
    todel.delete();
    size--;
    return true;
  }

  public int getFront() {
    return front.next.val;
  }

  public int getRear() {
    return rear.prev.val;
  }

  public boolean isEmpty() {
    if (size == 0)
      return true;
    return false;
  }

  public boolean isFull() {
    if (size == k)
      return true;
    return false;
  }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
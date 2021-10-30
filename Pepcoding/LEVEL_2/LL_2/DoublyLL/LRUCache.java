import java.util.*;

class LRUCache {
  private class Node {
    int value ;
    int key ;
    Node prev;
    Node next;

    // Node(int data) {
    // this.value = data;
    // }
    Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.prev = this.next = null;
    }
  }

  private Node head = null;
  private Node tail = null;
  private int size = 0;
  private HashMap<Integer, Node> map = null;
  private int capacity = 0;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      // get node and move it to the top of the list
      Node nn = map.get(key);
      // update
      this.put(key, nn.value);
      return nn.value;
    } else
      return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      // update - remove and send key to the top of list
      Node nn = map.get(key);
      nn.value = value;
      removeNode(nn);
      // last element is the most recent node
      addLast(nn);
    } else {
      // insert at last.Last elem is the most recent elem used
      Node nn = new Node(key, value);
      map.put(key, nn);
      addLast(nn);
      if (this.size > this.capacity) {
        int remKey = removeFirst();
        map.remove(remKey);
      }
    }
  }

  public void removeNode(Node node) {
    if (this.size == 1) {
      this.head = this.tail = null;

    } else if (node == this.head) {
      head = head.next;
      head.prev = null;
    } else if (node == tail) {
      tail = tail.prev;
      tail.next = null;

    } else {
      Node prevNode = node.prev;
      Node fwd = node.next;
      prevNode.next = fwd;
      fwd.prev = prevNode;
    }
    this.size--;
  }

  public int removeFirst() {
    Node rem = this.head;
    this.head = this.head.next;
    this.head.prev = null;
    rem.next = null;

    this.size--;
    return rem.key;
  }

  public void addLast(Node node) {
    if (this.size == 0) {
      this.head = this.tail = node;
    } else {
      this.tail.next = node;
      node.prev = this.tail;
      this.tail = node;

    }
    this.size++;
  }
}
/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
package LinkedList;

public class LL_ToQueue {
  public static class LLToQueueAdapter {
    LinkedList<Integer> list;

    public LLToQueueAdapter() {
      list = new LinkedList<>();
    }

    int size() {
      // write your code here
      return list.size();
    }

    void add(int val) {
      // write your code here
       list.addFirst(val);
    }

    int remove() {
      // write your code here
      if(this.size()==0){
          System.out.println("Queue underflow");
          return -1;
      }
      return list.removeLast();
    }

    int peek() {
      // write your code here
       if(this.size()==0){
          System.out.println("Queue underflow");
          return -1;
      }
      return list.getLast();
    }
}

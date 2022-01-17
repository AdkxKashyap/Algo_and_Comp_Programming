package Main.LEVEL_2.LL_2-2.LL_2;
//using hashmap (easier that part 1)
//lc 138
class Solution {
    
  public Node copyLL(Node head) {
      Node t1 = head;
      Node dummy = new Node(-1);
      Node t2 = dummy;
      while(t1 != null) {
          Node nn = new Node(t1.val);
          t2.next = nn;
          t2 = nn;
          t1 = t1.next;
      }
      return dummy.next;
  }
  public Node copyRandomList(Node head) {
      Node clonehead = copyLL(head);
      Map<Node, Node> map= new HashMap<>();
      Node t1 = head;
      Node t2 = clonehead;
      while(t1 != null) {
          map.put(t1, t2);
          t1 = t1.next;
          t2 = t2.next;
      }
      
      for(Node oNode : map.keySet()) {
          Node cNode = map.get(oNode);
          Node rNode = (oNode.random == null) ? null : map.get(oNode.random);
          cNode.random = rNode;
      }
      return clonehead;
  }
}

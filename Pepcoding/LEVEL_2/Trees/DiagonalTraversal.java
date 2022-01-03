import java.util.*;

class DiagonalTraversal
{
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
           ArrayList<Integer> res = new ArrayList<>();
           Queue<Node> que = new LinkedList<>();
           que.add(root);
           while(que.size() > 0) {
               Node rem = que.poll();
               Node tmp = rem;
               while(tmp != null) {
                   res.add(tmp.data);
                   if(tmp.left != null) que.add(tmp.left);
                   tmp = tmp.right;
               }
           }
           return res;
      }
}

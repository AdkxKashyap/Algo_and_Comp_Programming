import java.util.*;

class Solution {
  public List<String> findItinerary(List<List<String>> tickets) {
    // src -> dest sorted lexico. using pq
    HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
    // create the graph
    for (List<String> ticket : tickets) {
      PriorityQueue<String> tmp = graph.getOrDefault(ticket.get(0), new PriorityQueue<>());
      tmp.add(ticket.get(1));// add dest
      graph.put(ticket.get(0), tmp);
    }
    String src = "JFK";
    LinkedList<String> res = new LinkedList<>(); 
    dfs(graph, src, res);
    List<Integer> ls= new LinkedList<>();
    return res;
  }

  public static void dfs(HashMap<String, PriorityQueue<String>> graph,String src, LinkedList<String> res) {
    PriorityQueue<String> pq = graph.get(src);
    while(pq != null && pq.size() > 0) {
      String dest = pq.poll();
      dfs(graph, dest, res);
    }
    res.addFirst(src);
  }
}
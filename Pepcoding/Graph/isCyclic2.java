package Graph;

import java.util.*;
/**is cyclic for directed graph 
 * Question - https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#
 * Explain - see graph vid 6
*/
class isCyclic2 
{
    public boolean dfsCycle(ArrayList<ArrayList<Integer>> adj, int src, boolean[] myPath, boolean[] vis) {
        vis[src] = true;
        myPath[src] = true;
        
        for(int nbr : adj.get(src)) {
            if(myPath[nbr] == true) {
                return true;
            }
            else if(vis[nbr] == false) {
                boolean res = dfsCycle(adj, nbr, myPath, vis);
                if(res == true) return true;
            }
        }
        myPath[src] = false;
        return false;
    }
    //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        boolean[] myPath = new boolean[V];
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(vis[i] == false) {
                boolean res = dfsCycle(adj,  i,  myPath,  vis);
                if(res == true) return true;
            } 
        }
        return false;
    }
}

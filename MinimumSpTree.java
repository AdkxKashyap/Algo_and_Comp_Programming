//code--https://www.youtube.com/watch?v=09_LlHjoEiY&t=12920s
//explain--https://www.youtube.com/watch?v=4ZlRH0eK-qQ

import java.util.Comparator;
import java.util.PriorityQueue;

class MSP{
    public Edge[] findMsp(int graph[][]){
        int m=graph.length-1;//edges in MST=vertices-1
        int count=0,mstCost=0;
        int[] visited=new int[graph.length];
        Edge[] mst=new Edge[m];

        PriorityQueue<Edge>pq=new PriorityQueue<>(graph.length,new EdgeComparator());
        //adding 1st node
        visited[count]=1;
        //add all edges from 1st node
        for(int i=0;i<graph.length;i++){
            if(graph[0][i]!=0){
                pq.add(new Edge(0,i,graph[0][i]));
            }
        }
        while(!pq.isEmpty() && count<=m){
            Edge edge=pq.poll();
            if(visited[edge.to]==1)continue;//if already visited.
            visited[edge.to]=1;//setting current node visited to true
            mst[++count]=edge;
            for(int i=0;i<graph.length;i++){
                if(graph[edge.to][i]!=0){
                    pq.add(new Edge(edge.to, i, graph[edge.to][i]));
                }
            }
        }
        if(count<m)return null;
        return mst;
    }
}

class Edge{
    int from,to,cost;
    Edge(int from,int to,int cost){
        this.from=from;
        this.to=to;
        this.cost=cost;
    }
}
class EdgeComparator implements Comparator<Edge>{

	@Override
	public int compare(Edge o1, Edge o2) {
		if(o1.cost<o2.cost)return 1;
        if(o1.cost>o2.cost)return -1;
		return 0;
	}
    
}
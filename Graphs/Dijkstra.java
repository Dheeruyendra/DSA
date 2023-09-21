package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
   
       static class Pair{
        int node, dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    //TC => O(E*logV) where E = edges, V = vertices
    //SC => O(V) for dist array and O(V) for priority queue
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src)
    {  int n = adj.size();
       int[] dist = new int[V];
       Arrays.fill(dist, Integer.MAX_VALUE-1);
       PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.dist-b.dist));//min-priority queue based on distance
       Pair start = new Pair(src, 0); //node = 0, dist = 0
       pq.add(start);
       dist[src] = 0;
    
       while(!pq.isEmpty()){
           Pair curr = pq.poll(); 
           if(curr.dist > dist[curr.node])continue;
           
           for(ArrayList<Integer> next : adj.get(curr.node)){
               int  nextNode = next.get(0);
               int  nextWt = next.get(1);
               
               if(curr.dist+nextWt < dist[nextNode]){
                   dist[nextNode] = curr.dist+nextWt;
                   pq.add(new Pair(nextNode, dist[nextNode]));
               }
           }
       }
        return dist;
    }
    
  
}
